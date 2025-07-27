package org.fastcampus.post.domain.application.dto;

public record UpdateCommentRequestDto(Long commentId, Long userId, String contnent) {
}
