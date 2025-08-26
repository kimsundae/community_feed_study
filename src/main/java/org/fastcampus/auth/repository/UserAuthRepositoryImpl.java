package org.fastcampus.auth.repository;

import lombok.RequiredArgsConstructor;
import org.fastcampus.auth.application.interfaces.UserAuthRepository;
import org.fastcampus.auth.domain.UserAuth;
import org.fastcampus.auth.repository.entity.UserAuthEntitiy;
import org.fastcampus.auth.repository.jpa.JpaUserAuthRepository;
import org.fastcampus.user.application.interfaces.UserRepository;
import org.fastcampus.user.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserAuthRepositoryImpl implements UserAuthRepository {

    private final JpaUserAuthRepository jpaUserAuthRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserAuth registerUser(UserAuth auth, User user) {
        User savedUser = userRepository.save(user);
        UserAuthEntitiy userAuthEntitiy = new UserAuthEntitiy(auth,savedUser.getId());
        userAuthEntitiy = jpaUserAuthRepository.save(userAuthEntitiy);
        return userAuthEntitiy.toUserAuth();
    }
}
