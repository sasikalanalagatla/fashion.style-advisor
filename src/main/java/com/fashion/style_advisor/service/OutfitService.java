package com.fashion.style_advisor.service;

import com.fashion.style_advisor.enums.Climate;
import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.Outfit;

public interface OutfitService {
    Outfit suggestOutfit(Climate climate, PersonType personType);
}
