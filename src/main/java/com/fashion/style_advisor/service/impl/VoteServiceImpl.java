package com.fashion.style_advisor.service.impl;

import com.fashion.style_advisor.model.Outfit;
import com.fashion.style_advisor.repository.OutfitRepository;
import com.fashion.style_advisor.service.VoteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    private final OutfitRepository outfitRepository;

    public VoteServiceImpl(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    @Override
    public Outfit likeOutfit(Long outfitId) {
        Optional<Outfit> outfitOptional = outfitRepository.findById(outfitId);
        if (outfitOptional.isPresent()) {
            Outfit outfit = outfitOptional.get();
            outfit.setLikes(outfit.getLikes() + 1);
            return outfitRepository.save(outfit);
        }
        return null;
    }

    @Override
    public Outfit dislikeOutfit(Long outfitId) {
        Optional<Outfit> outfitOptional = outfitRepository.findById(outfitId);
        if (outfitOptional.isPresent()) {
            Outfit outfit = outfitOptional.get();
            outfit.setDislikes(outfit.getDislikes() + 1);
            return outfitRepository.save(outfit);
        }
        return null;
    }

    @Override
    public Outfit removeLike(Long outfitId) {
        Optional<Outfit> outfitOptional = outfitRepository.findById(outfitId);
        if (outfitOptional.isPresent()) {
            Outfit outfit = outfitOptional.get();
            if (outfit.getLikes() > 0) {
                outfit.setLikes(outfit.getLikes() - 1);
                return outfitRepository.save(outfit);
            }
            return outfit;
        }
        return null;
    }

    @Override
    public Outfit removeDislike(Long outfitId) {
        Optional<Outfit> outfitOptional = outfitRepository.findById(outfitId);
        if (outfitOptional.isPresent()) {
            Outfit outfit = outfitOptional.get();
            if (outfit.getDislikes() > 0) {
                outfit.setDislikes(outfit.getDislikes() - 1);
                return outfitRepository.save(outfit);
            }
            return outfit;
        }
        return null;
    }
}
