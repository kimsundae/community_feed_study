package org.fastcampus.post.domain.application.interfaces;

import org.fastcampus.post.domain.comment.Comment;

import java.util.Optional;

public interface CommentRepository {
    Comment save(Comment comment);
    Optional<Comment> findById(Long id);
}
