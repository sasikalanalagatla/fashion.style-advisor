package com.fashion.style_advisor.controller;

import com.fashion.style_advisor.enums.Climate;
import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.Outfit;
import com.fashion.style_advisor.service.OutfitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OutfitController {

    private final OutfitService outfitService;

    public OutfitController(OutfitService outfitService) {
        this.outfitService = outfitService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("climates", Climate.values());
        model.addAttribute("personTypes", PersonType.values());
        return "home";
    }

    @PostMapping("/suggest")
    public String suggestOutfit(@RequestParam Climate climate, @RequestParam PersonType personType, Model model) {
        Outfit outfit = outfitService.suggestOutfit(climate, personType);
        model.addAttribute("outfit", outfit);
        return "outfit";
    }

    @GetMapping("/outfit/{id}")
    public String getOutfit(@PathVariable Long id, Model model) {
        Outfit outfit = outfitService.getOutfitById(id);
        model.addAttribute("outfit", outfit);
        return "outfit";
    }
}
