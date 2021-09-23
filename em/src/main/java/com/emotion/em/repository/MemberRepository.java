package com.emotion.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.emotion.em.Entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByEmail(String userEmail);
}
