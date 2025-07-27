package org.fastcampus.post.domain.application.interfaces;

import org.fastcampus.post.domain.Post;

import java.util.Optional;

public interface PostRepository {

    Post save(Post post);

    Optional<Post> findById(Long id);

}
