package com.fashion.style_advisor.controller;

import com.fashion.style_advisor.enums.Climate;
import com.fashion.style_advisor.enums.ClothingCategory;
import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.Avatar;
import com.fashion.style_advisor.model.ClothingItem;
import com.fashion.style_advisor.model.Outfit;
import com.fashion.style_advisor.repository.ClothingItemRepository;
import com.fashion.style_advisor.service.AvatarService;
import com.fashion.style_advisor.service.OutfitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OutfitController {

    private final OutfitService outfitService;
    private final ClothingItemRepository clothingItemRepository;
    private final AvatarService avatarService;

    public OutfitController(OutfitService outfitService, ClothingItemRepository clothingItemRepository, AvatarService avatarService) {
        this.outfitService = outfitService;
        this.clothingItemRepository = clothingItemRepository;
        this.avatarService = avatarService;
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
        
        // Add avatar to model
        List<Avatar> avatars = avatarService.getAvatarsByPersonType(personType);
        if (!avatars.isEmpty()) {
            model.addAttribute("avatar", avatars.get(0));
        } else {
            model.addAttribute("avatar", new Avatar("Default", personType));
        }
        
        return "outfit";
    }

    @GetMapping("/outfit/{id}")
    public String getOutfit(@PathVariable Long id, Model model) {
        Outfit outfit = outfitService.getOutfitById(id);
        model.addAttribute("outfit", outfit);
        
        // Add avatar to model
        if (outfit != null && outfit.getPersonType() != null) {
            List<Avatar> avatars = avatarService.getAvatarsByPersonType(outfit.getPersonType());
            if (!avatars.isEmpty()) {
                model.addAttribute("avatar", avatars.get(0));
            } else {
                model.addAttribute("avatar", new Avatar("Default", outfit.getPersonType()));
            }
        }
        
        return "outfit";
    }

    @GetMapping("/browse")
    public String browseItems(@RequestParam(required = false) Climate climate,
                             @RequestParam(required = false) PersonType personType,
                             @RequestParam(required = false) ClothingCategory category,
                             Model model) {
        List<ClothingItem> items;

        if (climate != null && personType != null && category != null) {
            items = clothingItemRepository.findByClimateAndPersonTypeAndCategory(climate, personType, category);
        } else if (climate != null && personType != null) {
            items = clothingItemRepository.findByClimateAndPersonType(climate, personType);
        } else if (climate != null) {
            items = clothingItemRepository.findByClimate(climate);
        } else if (personType != null) {
            items = clothingItemRepository.findByPersonType(personType);
        } else if (category != null) {
            items = clothingItemRepository.findByCategory(category);
        } else {
            items = clothingItemRepository.findAll();
        }

        model.addAttribute("items", items);
        model.addAttribute("climates", Climate.values());
        model.addAttribute("personTypes", PersonType.values());
        model.addAttribute("categories", ClothingCategory.values());
        model.addAttribute("selectedClimate", climate);
        model.addAttribute("selectedPersonType", personType);
        model.addAttribute("selectedCategory", category);
        return "browse_items";
    }

    @PostMapping("/suggest-with-item")
    public String suggestOutfitWithItem(@RequestParam Long itemId,
                                       @RequestParam ClothingCategory category,
                                       @RequestParam Climate climate,
                                       @RequestParam PersonType personType,
                                       Model model) {
        Outfit outfit = outfitService.suggestOutfitWithItem(itemId, category, climate, personType);
        model.addAttribute("outfit", outfit);
        
        // Add avatar to model
        List<Avatar> avatars = avatarService.getAvatarsByPersonType(personType);
        if (!avatars.isEmpty()) {
            model.addAttribute("avatar", avatars.get(0));
        } else {
            model.addAttribute("avatar", new Avatar("Default", personType));
        }
        
        return "outfit";
    }
}
