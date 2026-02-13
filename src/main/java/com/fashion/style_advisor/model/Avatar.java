package com.fashion.style_advisor.model;

import com.fashion.style_advisor.enums.PersonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    // Avatar customization parts
    private String skinTone;      // e.g., light, medium, dark
    private String faceShape;     // e.g., round, square, oval
    private String eyeShape;      // e.g., round, almond, wide
    private String eyeColor;      // e.g., brown, blue, green
    private String noseShape;     // e.g., straight, curved, small
    private String mouthShape;    // e.g., smile, neutral, heart
    private String hairStyle;     // e.g., long, short, curly, straight
    private String hairColor;     // e.g., black, brown, blonde, red
    private String accessories;   // e.g., glasses, hat, etc (JSON string with multiple items)

    // Default constructor
    public Avatar() {
    }

    // Constructor with parameters
    public Avatar(String name, PersonType personType) {
        this.name = name;
        this.personType = personType;
        this.skinTone = "light";
        this.faceShape = "round";
        this.eyeShape = "round";
        this.eyeColor = "brown";
        this.noseShape = "straight";
        this.mouthShape = "smile";
        this.hairStyle = "long";
        this.hairColor = "black";
    }
}
