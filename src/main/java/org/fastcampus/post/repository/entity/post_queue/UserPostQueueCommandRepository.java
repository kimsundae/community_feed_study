package org.fastcampus.post.repository.entity.post_queue;

import org.fastcampus.post.repository.entity.post.PostEntity;

public interface UserPostQueueCommandRepository {
    void publishPost(PostEntity postEntity);
    void saveFollowPost(Long userId, Long targetId);
    void deleteFollowPost(Long userId, Long targetId);
}
