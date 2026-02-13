package com.fashion.style_advisor.model;

import com.fashion.style_advisor.enums.PersonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AvatarPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partType;      // e.g., "skinTone", "hairStyle", "eyeShape", etc.
    
    private String partName;      // e.g., "Light Skin", "Long Hair", "Round Eyes"
    
    private String partValue;     // e.g., "light", "long", "round"
    
    @Enumerated(EnumType.STRING)
    private PersonType personType; // MALE, FEMALE, CHILD (null means all types)
    
    private String svgCode;       // SVG path or code to render this part
    
    private String htmlCode;      // Alternative HTML/CSS to render this part

    // Default constructor
    public AvatarPart() {
    }

    // Constructor
    public AvatarPart(String partType, String partName, String partValue, PersonType personType, String svgCode) {
        this.partType = partType;
        this.partName = partName;
        this.partValue = partValue;
        this.personType = personType;
        this.svgCode = svgCode;
    }
}
