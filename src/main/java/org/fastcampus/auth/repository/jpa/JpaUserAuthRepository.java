package org.fastcampus.auth.repository.jpa;

import org.fastcampus.auth.domain.UserAuth;
import org.fastcampus.auth.repository.entity.UserAuthEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserAuthRepository extends JpaRepository<UserAuthEntitiy,String> {

}
