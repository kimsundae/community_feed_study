package org.fastcampus.post.domain.application.dto;

import org.fastcampus.post.domain.content.PostPublicationState;

public record CreatePostRequestDto(Long userId, String content, PostPublicationState state) {
}
