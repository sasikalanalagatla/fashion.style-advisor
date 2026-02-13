package com.fashion.style_advisor.controller;

import com.fashion.style_advisor.model.ClothingItem;
import com.fashion.style_advisor.repository.ClothingItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HealthController {

    private final ClothingItemRepository clothingItemRepository;

    public HealthController(ClothingItemRepository clothingItemRepository) {
        this.clothingItemRepository = clothingItemRepository;
    }

    @GetMapping("/api/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new HashMap<>();
        long totalItems = clothingItemRepository.count();
        response.put("status", "UP");
        response.put("totalClothingItems", totalItems);
        
        List<ClothingItem> sampleItems = clothingItemRepository.findAll();
        if (!sampleItems.isEmpty()) {
            Map<String, String> sample = new HashMap<>();
            ClothingItem item = sampleItems.get(0);
            sample.put("id", item.getId().toString());
            sample.put("name", item.getName());
            sample.put("imagePath", item.getImagePath());
            sample.put("climate", item.getClimate().toString());
            response.put("sampleItem", sample);
        }
        
        return ResponseEntity.ok(response);
    }
}
