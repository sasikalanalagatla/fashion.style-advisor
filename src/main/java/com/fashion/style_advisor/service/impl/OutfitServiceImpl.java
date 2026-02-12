package com.fashion.style_advisor.service.impl;

import com.fashion.style_advisor.enums.Climate;
import com.fashion.style_advisor.enums.ClothingCategory;
import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.ClothingItem;
import com.fashion.style_advisor.model.Outfit;
import com.fashion.style_advisor.repository.ClothingItemRepository;
import com.fashion.style_advisor.repository.OutfitRepository;
import com.fashion.style_advisor.service.OutfitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutfitServiceImpl implements OutfitService {

    private final ClothingItemRepository clothingItemRepository;
    private final OutfitRepository outfitRepository;

    public OutfitServiceImpl(ClothingItemRepository clothingItemRepository, OutfitRepository outfitRepository) {
        this.clothingItemRepository = clothingItemRepository;
        this.outfitRepository = outfitRepository;
    }

    @Override
    public Outfit suggestOutfit(Climate climate, PersonType personType) {
        List<ClothingItem> tops = clothingItemRepository.findByClimateAndPersonTypeAndCategory(climate, personType, ClothingCategory.TOP);
        List<ClothingItem> bottoms = clothingItemRepository.findByClimateAndPersonTypeAndCategory(climate, personType, ClothingCategory.BOTTOM);
        List<ClothingItem> accessories = clothingItemRepository.findByClimateAndPersonTypeAndCategory(climate, personType, ClothingCategory.ACCESSORY);

        Outfit outfit = new Outfit();
        outfit.setClimate(climate);
        outfit.setPersonType(personType);

        if (!tops.isEmpty()) {
            outfit.setTopwear(tops.get(0));
        }
        if (!bottoms.isEmpty()) {
            outfit.setBottomwear(bottoms.get(0));
        }
        outfit.setAccessories(accessories.stream().limit(3).toList());
        return outfitRepository.save(outfit);
    }

    @Override
    public List<Outfit> getMostLikedOutfits() {
        return outfitRepository.findTop10ByOrderByLikesDesc();
    }

    @Override
    public Outfit getOutfitById(Long id) {
        return outfitRepository.findById(id).orElse(null);
    }
}
