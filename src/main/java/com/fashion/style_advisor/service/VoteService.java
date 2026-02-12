package com.fashion.style_advisor.service;

import com.fashion.style_advisor.model.Outfit;

public interface VoteService {
    Outfit likeOutfit(Long outfitId);
    Outfit dislikeOutfit(Long outfitId);
    Outfit removeLike(Long outfitId);
    Outfit removeDislike(Long outfitId);
}
