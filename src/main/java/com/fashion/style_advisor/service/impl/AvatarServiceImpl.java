package com.fashion.style_advisor.service.impl;

import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.Avatar;
import com.fashion.style_advisor.model.AvatarPart;
import com.fashion.style_advisor.repository.AvatarRepository;
import com.fashion.style_advisor.repository.AvatarPartRepository;
import com.fashion.style_advisor.service.AvatarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvatarServiceImpl implements AvatarService {

    private final AvatarRepository avatarRepository;
    private final AvatarPartRepository avatarPartRepository;

    public AvatarServiceImpl(AvatarRepository avatarRepository, AvatarPartRepository avatarPartRepository) {
        this.avatarRepository = avatarRepository;
        this.avatarPartRepository = avatarPartRepository;
    }

    @Override
    public Avatar createOrUpdateAvatar(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    @Override
    public Avatar getAvatarById(Long id) {
        return avatarRepository.findById(id).orElse(null);
    }

    @Override
    public List<Avatar> getAvatarsByPersonType(PersonType personType) {
        return avatarRepository.findByPersonType(personType);
    }

    @Override
    public List<AvatarPart> getPartsByType(String partType) {
        return avatarPartRepository.findByPartType(partType);
    }

    @Override
    public List<AvatarPart> getPartsByTypeAndPersonType(String partType, PersonType personType) {
        List<AvatarPart> specificParts = avatarPartRepository.findByPartTypeAndPersonType(partType, personType);
        List<AvatarPart> generalParts = avatarPartRepository.findByPartTypeAndPersonTypeIsNull(partType);
        specificParts.addAll(generalParts);
        return specificParts;
    }

    @Override
    public void initializeAvatarParts() {
        // Check if parts already exist
        List<AvatarPart> existingParts = avatarPartRepository.findAll();
        if (!existingParts.isEmpty()) {
            return; // Already initialized
        }

        // Skin Tones
        avatarPartRepository.save(new AvatarPart("skinTone", "Light Skin", "light", null, "#f4c2a0"));
        avatarPartRepository.save(new AvatarPart("skinTone", "Medium Skin", "medium", null, "#d4a574"));
        avatarPartRepository.save(new AvatarPart("skinTone", "Dark Skin", "dark", null, "#9d7962"));

        // Hair Styles
        avatarPartRepository.save(new AvatarPart("hairStyle", "Long Hair", "long", null, "long"));
        avatarPartRepository.save(new AvatarPart("hairStyle", "Short Hair", "short", null, "short"));
        avatarPartRepository.save(new AvatarPart("hairStyle", "Curly Hair", "curly", null, "curly"));
        avatarPartRepository.save(new AvatarPart("hairStyle", "Straight Hair", "straight", null, "straight"));

        // Hair Colors
        avatarPartRepository.save(new AvatarPart("hairColor", "Black", "black", null, "#1a1a1a"));
        avatarPartRepository.save(new AvatarPart("hairColor", "Brown", "brown", null, "#6b4423"));
        avatarPartRepository.save(new AvatarPart("hairColor", "Blonde", "blonde", null, "#d4a574"));
        avatarPartRepository.save(new AvatarPart("hairColor", "Red", "red", null, "#c41e3a"));

        // Eye Colors
        avatarPartRepository.save(new AvatarPart("eyeColor", "Brown Eyes", "brown", null, "#8b4513"));
        avatarPartRepository.save(new AvatarPart("eyeColor", "Blue Eyes", "blue", null, "#4a90e2"));
        avatarPartRepository.save(new AvatarPart("eyeColor", "Green Eyes", "green", null, "#2ecc71"));
        avatarPartRepository.save(new AvatarPart("eyeColor", "Hazel Eyes", "hazel", null, "#a67c52"));

        // Eye Shapes
        avatarPartRepository.save(new AvatarPart("eyeShape", "Round Eyes", "round", null, "round"));
        avatarPartRepository.save(new AvatarPart("eyeShape", "Almond Eyes", "almond", null, "almond"));
        avatarPartRepository.save(new AvatarPart("eyeShape", "Wide Eyes", "wide", null, "wide"));

        // Face Shapes
        avatarPartRepository.save(new AvatarPart("faceShape", "Round Face", "round", null, "round"));
        avatarPartRepository.save(new AvatarPart("faceShape", "Square Face", "square", null, "square"));
        avatarPartRepository.save(new AvatarPart("faceShape", "Oval Face", "oval", null, "oval"));

        // Mouth Shapes
        avatarPartRepository.save(new AvatarPart("mouthShape", "Smile", "smile", null, "smile"));
        avatarPartRepository.save(new AvatarPart("mouthShape", "Neutral", "neutral", null, "neutral"));
        avatarPartRepository.save(new AvatarPart("mouthShape", "Heart", "heart", null, "heart"));
    }
}
