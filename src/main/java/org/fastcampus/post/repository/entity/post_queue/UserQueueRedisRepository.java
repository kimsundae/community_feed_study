package org.fastcampus.post.repository.entity.post_queue;

import org.fastcampus.post.repository.entity.post.PostEntity;

import java.util.List;

public interface UserQueueRedisRepository {
    void publishPostToFollowingUserList(PostEntity postEntity, List<Long> userIdList);
    void publishPostListToFollowerUser(List<PostEntity> postEntityList, Long userId);
    void deleteDeleteFeed(Long userId, Long authorId);
}
