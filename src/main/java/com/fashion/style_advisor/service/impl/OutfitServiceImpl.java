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
        
        if (outfit.getTopwear() != null && outfit.getBottomwear() != null) {
            String imageUrl = String.format("/images/outfits/%d_%d.png", 
                outfit.getTopwear().getId(), 
                outfit.getBottomwear().getId());
            outfit.setImageUrl(imageUrl);
        }

        return outfitRepository.save(outfit);
    }

    @Override
    public Outfit suggestOutfitWithItem(Long itemId, ClothingCategory category, Climate climate, PersonType personType) {
        ClothingItem selectedItem = clothingItemRepository.findById(itemId).orElse(null);
        
        Outfit outfit = new Outfit();
        outfit.setClimate(climate);
        outfit.setPersonType(personType);

        if (selectedItem != null) {
            // Set the selected item to the appropriate position
            if (category == ClothingCategory.TOP) {
                outfit.setTopwear(selectedItem);
            } else if (category == ClothingCategory.BOTTOM) {
                outfit.setBottomwear(selectedItem);
            } else if (category == ClothingCategory.ACCESSORY) {
                outfit.setAccessories(List.of(selectedItem));
            }

            // Fill in missing items
            if (outfit.getTopwear() == null) {
                List<ClothingItem> tops = clothingItemRepository.findByClimateAndPersonTypeAndCategory(climate, personType, ClothingCategory.TOP);
                if (!tops.isEmpty()) {
                    outfit.setTopwear(tops.get(0));
                }
            }

            if (outfit.getBottomwear() == null) {
                List<ClothingItem> bottoms = clothingItemRepository.findByClimateAndPersonTypeAndCategory(climate, personType, ClothingCategory.BOTTOM);
                if (!bottoms.isEmpty()) {
                    outfit.setBottomwear(bottoms.get(0));
                }
            }

            if (outfit.getAccessories() == null || outfit.getAccessories().isEmpty()) {
                List<ClothingItem> accessories = clothingItemRepository.findByClimateAndPersonTypeAndCategory(climate, personType, ClothingCategory.ACCESSORY);
                if (!accessories.isEmpty()) {
                    outfit.setAccessories(accessories.stream().limit(3).toList());
                }
            }

            if (outfit.getTopwear() != null && outfit.getBottomwear() != null) {
                String imageUrl = String.format("/images/outfits/%d_%d.png", 
                    outfit.getTopwear().getId(), 
                    outfit.getBottomwear().getId());
                outfit.setImageUrl(imageUrl);
            }
        }

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
