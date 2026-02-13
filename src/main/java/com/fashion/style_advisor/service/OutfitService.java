package com.fashion.style_advisor.service;

import com.fashion.style_advisor.enums.Climate;
import com.fashion.style_advisor.enums.ClothingCategory;
import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.Outfit;
import java.util.List;

public interface OutfitService {
    Outfit suggestOutfit(Climate climate, PersonType personType);
    Outfit suggestOutfitWithItem(Long itemId, ClothingCategory category, Climate climate, PersonType personType);
    List<Outfit> getMostLikedOutfits();
    Outfit getOutfitById(Long id);
}

