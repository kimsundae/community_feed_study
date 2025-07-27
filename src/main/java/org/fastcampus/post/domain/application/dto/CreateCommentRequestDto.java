package org.fastcampus.post.domain.application.dto;

public record CreateCommentRequestDto(Long postId, Long userId, String content) {
}
