package org.fastcampus.post.repository.jpa;

import java.util.List;
import org.fastcampus.post.repository.entity.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {

    @Query("SELECT p.id FROM PostEntity p WHERE p.author.id = :id")
    List<Long> findAllPostIdsByAuthorId(Long id);

    @Modifying
    @Query(value = "UPDATE PostEntity p " +
            " SET p.content = :#{#postEntity.getContent()}, " +
            " p.state = :#{#postEntity.getState()}," +
            " p.upDt = now()" +
            " where p.id = :#{#postEntity.id}")
    void updatePostEntity(PostEntity postEntity);

    @Modifying
    @Query(value = "UPDATE PostEntity p"
            + " SET p.likeCount = :likeCount, " +
            " p.upDt = now() " +
            " WHERE p.id = :postId")
    void updateLikeCount(Long postId, Integer likeCount);

    @Modifying
    @Query(value = "UPDATE PostEntity p" +
            " SET p.commentCount = p.commentCount + 1," +
            " p.upDt = now() " +
            "WHERE p.id = :id")
    void increaseCommentCount(Long id);
}
