package org.fastcampus.post.repository;

import org.fastcampus.post.repository.entity.post_queue.UserQueueRedisRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"!test"})
public class UserQueueRedisRepositoryImpl implements UserQueueRedisRepository {
    @Override
    public void publishPostToFollowingUserList(org.fastcampus.post.repository.entity.post.PostEntity postEntity, java.util.List<Long> userIdList) {

    }

    @Override
    public void publishPostListToFollowerUser(java.util.List<org.fastcampus.post.repository.entity.post.PostEntity> postEntityList, Long userId) {

    }

    @Override
    public void deleteDeleteFeed(Long userId, Long authorId) {

    }
}
