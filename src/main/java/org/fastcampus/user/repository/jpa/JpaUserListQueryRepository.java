package org.fastcampus.user.repository.jpa;

import java.util.List;
import org.fastcampus.user.repository.entity.UserEntity;

public interface JpaUserListQueryRepository extends JpaUserRepository<UserEntity, Long>{
    getFollwingUserList(Long userId);
    getFollowerUserList(Long userId);
}
