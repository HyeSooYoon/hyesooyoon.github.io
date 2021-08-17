package com.emotion.em.repository;

import com.emotion.em.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    
    Optional<UserInfo> findByName(String name);
    void deleteByName(String name);
}
