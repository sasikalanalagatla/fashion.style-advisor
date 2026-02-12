package com.fashion.style_advisor.repository;

import com.fashion.style_advisor.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingItemRepository extends JpaRepository<ClothingItem,Long> {
}
