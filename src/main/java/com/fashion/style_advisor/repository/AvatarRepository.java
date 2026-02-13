package com.fashion.style_advisor.repository;

import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    List<Avatar> findByPersonType(PersonType personType);
}
