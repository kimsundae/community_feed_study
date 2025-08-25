package org.fastcampus.auth.repository.jpa;

import org.fastcampus.auth.repository.entity.EmailVerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaEmailVerificationRepository extends JpaRepository<EmailVerificationEntity,Integer> {
    Optional<EmailVerificationEntity> findByEmail(String email);
}
