package com.fashion.style_advisor.model;

import com.fashion.style_advisor.enums.Climate;
import com.fashion.style_advisor.enums.PersonType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Outfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Climate climate;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    @ManyToOne
    private ClothingItem topwear;

    @ManyToOne
    private ClothingItem bottomwear;

    @ManyToMany
    @JoinTable(
            name = "outfit_accessories",
            joinColumns = @JoinColumn(name = "outfit_id"),
            inverseJoinColumns = @JoinColumn(name = "clothing_item_id")
    )
    private List<ClothingItem> accessories;

    private int likes;
    private int dislikes;

}
