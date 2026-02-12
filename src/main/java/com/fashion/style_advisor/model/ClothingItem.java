package com.fashion.style_advisor.model;

import com.fashion.style_advisor.enums.Climate;
import com.fashion.style_advisor.enums.ClothingCategory;
import com.fashion.style_advisor.enums.PersonType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ClothingCategory category;

    @Enumerated(EnumType.STRING)
    private Climate climate;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    private String imagePath;
}