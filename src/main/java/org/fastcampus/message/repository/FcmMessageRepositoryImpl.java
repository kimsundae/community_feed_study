package org.fastcampus.message.repository;

import lombok.RequiredArgsConstructor;
import org.fastcampus.message.application.interfaces.MessageRepository;
import org.fastcampus.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FcmMessageRepositoryImpl implements MessageRepository {
    @Override
    public void sendLikeMessage(User sender, User targetUser) {

    }
}
