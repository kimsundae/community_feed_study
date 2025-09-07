package org.fastcampus.post.repository;

import java.util.List;
import org.fastcampus.post.repository.entity.post_queue.UserPostQueueQueryRepository;
import org.fastcampus.user.ui.dto.GetPostContentResponseDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"!test"})
public class UserPostQueueQueryRepositoryImpl implements UserPostQueueQueryRepository {

    @Override
    public List<GetPostContentResponseDto> getContentResponse(Long userId, Long lastPostId) {
        return List.of();
    }
}
