package com.fashion.style_advisor.service;

import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.Avatar;
import com.fashion.style_advisor.model.AvatarPart;
import java.util.List;
import java.util.Map;

public interface AvatarService {
    Avatar createOrUpdateAvatar(Avatar avatar);
    Avatar getAvatarById(Long id);
    List<Avatar> getAvatarsByPersonType(PersonType personType);
    List<AvatarPart> getPartsByType(String partType);
    List<AvatarPart> getPartsByTypeAndPersonType(String partType, PersonType personType);
    void initializeAvatarParts();
}
