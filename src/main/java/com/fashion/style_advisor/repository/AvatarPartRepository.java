package com.fashion.style_advisor.repository;

import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.AvatarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarPartRepository extends JpaRepository<AvatarPart, Long> {
    List<AvatarPart> findByPartType(String partType);
    List<AvatarPart> findByPartTypeAndPersonType(String partType, PersonType personType);
    List<AvatarPart> findByPartTypeAndPersonTypeIsNull(String partType);
}
