package org.fastcampus.user.application.interfaces;

import org.fastcampus.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User save(User user);
    User findById(Long id);

}
