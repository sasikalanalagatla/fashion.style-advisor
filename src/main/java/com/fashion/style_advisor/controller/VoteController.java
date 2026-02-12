package com.fashion.style_advisor.controller;

import com.fashion.style_advisor.model.Outfit;
import com.fashion.style_advisor.service.OutfitService;
import com.fashion.style_advisor.service.VoteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vote")
public class VoteController {

    private final OutfitService outfitService;
    private final VoteService voteService;

    public VoteController(OutfitService outfitService, VoteService voteService) {
        this.outfitService = outfitService;
        this.voteService = voteService;
    }

    @SuppressWarnings("unchecked")
    private Map<Long, String> getVoteHistory(HttpSession session) {
        Map<Long, String> voteHistory = (Map<Long, String>) session.getAttribute("voteHistory");
        if (voteHistory == null) {
            voteHistory = new HashMap<>();
            session.setAttribute("voteHistory", voteHistory);
        }
        return voteHistory;
    }

    @PostMapping("/{outfitId}/like")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> likeOutfit(@PathVariable Long outfitId, HttpSession session) {
        Map<Long, String> voteHistory = getVoteHistory(session);
        String currentVote = voteHistory.get(outfitId);
        Outfit updatedOutfit = null;

        if ("LIKE".equals(currentVote)) {
            updatedOutfit = voteService.removeLike(outfitId);
            voteHistory.remove(outfitId);
        } else if ("DISLIKE".equals(currentVote)) {
            voteService.removeDislike(outfitId);
            updatedOutfit = voteService.likeOutfit(outfitId);
            voteHistory.put(outfitId, "LIKE");
        } else {
            updatedOutfit = voteService.likeOutfit(outfitId);
            voteHistory.put(outfitId, "LIKE");
        }

        Map<String, Object> response = new HashMap<>();
        if (updatedOutfit != null) {
            response.put("likes", updatedOutfit.getLikes());
            response.put("dislikes", updatedOutfit.getDislikes());
            response.put("userVote", voteHistory.get(outfitId));
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{outfitId}/dislike")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> dislikeOutfit(@PathVariable Long outfitId, HttpSession session) {
        Map<Long, String> voteHistory = getVoteHistory(session);
        String currentVote = voteHistory.get(outfitId);
        Outfit updatedOutfit = null;

        if ("DISLIKE".equals(currentVote)) {
            updatedOutfit = voteService.removeDislike(outfitId);
            voteHistory.remove(outfitId);
        } else if ("LIKE".equals(currentVote)) {
            voteService.removeLike(outfitId);
            updatedOutfit = voteService.dislikeOutfit(outfitId);
            voteHistory.put(outfitId, "DISLIKE");
        } else {
            updatedOutfit = voteService.dislikeOutfit(outfitId);
            voteHistory.put(outfitId, "DISLIKE");
        }

        Map<String, Object> response = new HashMap<>();
        if (updatedOutfit != null) {
            response.put("likes", updatedOutfit.getLikes());
            response.put("dislikes", updatedOutfit.getDislikes());
            response.put("userVote", voteHistory.get(outfitId));
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/popular")
    public String getPopularOutfits(Model model) {
        List<Outfit> popularOutfits = outfitService.getMostLikedOutfits();
        model.addAttribute("outfits", popularOutfits);
        return "popular_outfits";
    }
}
