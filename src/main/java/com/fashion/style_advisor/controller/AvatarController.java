package com.fashion.style_advisor.controller;

import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.Avatar;
import com.fashion.style_advisor.service.AvatarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AvatarController {

    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @GetMapping("/avatar-builder")
    public String showAvatarBuilder(@RequestParam(required = false) PersonType personType, Model model) {
        PersonType selectedPersonType = personType != null ? personType : PersonType.FEMALE;
        
        // Create a new avatar with default values
        Avatar avatar = new Avatar("My Avatar", selectedPersonType);
        
        model.addAttribute("avatar", avatar);
        model.addAttribute("personType", selectedPersonType);
        model.addAttribute("skinTones", avatarService.getPartsByType("skinTone"));
        model.addAttribute("hairStyles", avatarService.getPartsByTypeAndPersonType("hairStyle", selectedPersonType));
        model.addAttribute("hairColors", avatarService.getPartsByType("hairColor"));
        model.addAttribute("eyeColors", avatarService.getPartsByType("eyeColor"));
        model.addAttribute("eyeShapes", avatarService.getPartsByType("eyeShape"));
        model.addAttribute("faceShapes", avatarService.getPartsByType("faceShape"));
        model.addAttribute("mouthShapes", avatarService.getPartsByType("mouthShape"));
        
        return "avatar-builder";
    }

    @PostMapping("/save-avatar")
    public String saveAvatar(@ModelAttribute Avatar avatar, Model model) {
        Avatar savedAvatar = avatarService.createOrUpdateAvatar(avatar);
        model.addAttribute("avatar", savedAvatar);
        model.addAttribute("successMessage", "Avatar saved successfully!");
        
        return "redirect:/avatar-builder?personType=" + avatar.getPersonType();
    }

    @GetMapping("/get-avatar-options")
    @ResponseBody
    public Object getAvatarOptions(@RequestParam String partType, 
                                   @RequestParam(required = false) PersonType personType) {
        if (personType != null) {
            return avatarService.getPartsByTypeAndPersonType(partType, personType);
        }
        return avatarService.getPartsByType(partType);
    }
}
