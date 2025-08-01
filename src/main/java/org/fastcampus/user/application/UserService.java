package org.fastcampus.user.application;

import org.fastcampus.user.application.dto.CreateuserRequestDto;
import org.fastcampus.user.application.interfaces.UserRepository;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;
import org.springframework.stereotype.Service;

import java.util.IllformedLocaleException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateuserRequestDto dto){
        UserInfo info = new UserInfo(dto.name(), dto.profileImageUrl());
        User user = new User(null,info);
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id);
    }
}
