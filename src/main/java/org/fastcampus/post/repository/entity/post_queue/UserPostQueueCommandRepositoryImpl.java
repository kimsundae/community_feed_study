package org.fastcampus.post.repository.entity.post_queue;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.fastcampus.post.repository.entity.post.UserPostQueueEntity;
import org.fastcampus.user.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.fastcampus.post.repository.jpa.JpaPostRepository;
import org.fastcampus.post.repository.entity.post.PostEntity;
import org.fastcampus.user.repository.jpa.JpaUserRelationRepository;
import org.fastcampus.post.repository.jpa.JpaUserPostQueueRepository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserPostQueueCommandRepositoryImpl implements UserPostQueueCommandRepository {

    private final JpaPostRepository jpaPostRepository;
    private final JpaUserRelationRepository jpaUserRelationRepository;
    private final UserQueueRedisRepository userQueueRedisRepository;

    @Override
    @Transactional
    public void publishPost(PostEntity postEntity) {
        UserEntity userEntity = postEntity.getAuthor();
        List<Long> followers = jpaUserRelationRepository.findFollowers(userEntity.getId());
        userQueueRedisRepository.publishPostToFollowingUserList(postEntity, followers);
    }

    @Override
    @Transactional
    public void saveFollowPost(Long userId, Long targetId) {
        List<PostEntity> postEntities = jpaPostRepository.findAllPostIdsByAuthorId(targetId);
        userQueueRedisRepository.publishPostListToFollowerUser(postEntities, userId);
    }

    @Override
    @Transactional
    public void deleteFollowPost(Long userId, Long targetId) {
        userQueueRedisRepository.deleteDeleteFeed(userId, targetId);
    }
}
