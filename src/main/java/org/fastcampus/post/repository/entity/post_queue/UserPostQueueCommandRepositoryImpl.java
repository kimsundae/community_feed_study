package org.fastcampus.post.repository.entity.post_queue;

import lombok.RequiredArgsConstructor;
import org.fastcampus.post.repository.entity.post.PostEntity;
import org.fastcampus.post.repository.jpa.JpaPostRepository;
import org.fastcampus.post.repository.jpa.JpaUserPostQueueRepository;
import org.fastcampus.user.repository.jpa.JpaUserRelationRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserPostQueueCommandRepositoryImpl implements UserPostQueueCommandRepository {

    private final JpaPostRepository jpaPostRepository;
    private final JpaUserRelationRepository jpaUserRelationRepository;
    private final JpaUserPostQueueRepository jpaUserPostQueueRepository;

    public UserPostQueueCommandRepositoryImpl(JpaUserPostQueueRepository jpaUserPostQueueRepository) {
        this.jpaUserPostQueueRepository = jpaUserPostQueueRepository;
    }

    @Override
    public void publishPost(PostEntity postEntity) {
        // Implementation for publishing a post
    }

    @Override
    public void saveFollowPost(Long userId, Long targetId) {
        // Implementation for saving a follow post
    }

    @Override
    public void deleteFollowPost(Long userId, Long targetId) {
        // Implementation for deleting a follow post
    }

}
