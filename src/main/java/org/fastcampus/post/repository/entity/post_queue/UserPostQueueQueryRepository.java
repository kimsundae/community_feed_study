package org.fastcampus.post.repository.entity.post_queue;

import java.util.List;
import org.fastcampus.user.ui.dto.GetPostContentResponseDto;

public interface UserPostQueueQueryRepository {
    List<GetPostContentResponseDto> getContentResponse(Long userId, Long lastPostId);
}
