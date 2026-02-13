package com.fashion.style_advisor.repository;

import com.fashion.style_advisor.enums.Climate;
import com.fashion.style_advisor.enums.ClothingCategory;
import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {
    List<ClothingItem> findByClimateAndPersonTypeAndCategory(Climate climate, PersonType personType, ClothingCategory category);
    List<ClothingItem> findByClimate(Climate climate);
    List<ClothingItem> findByPersonType(PersonType personType);
    List<ClothingItem> findByCategory(ClothingCategory category);
    List<ClothingItem> findByClimateAndPersonType(Climate climate, PersonType personType);
}

