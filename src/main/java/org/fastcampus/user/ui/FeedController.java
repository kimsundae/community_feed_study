package org.fastcampus.user.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.fastcampus.common.ui.Response;
import org.fastcampus.post.repository.entity.post_queue.UserPostQueueQueryRepository;
import org.fastcampus.user.ui.dto.GetPostContentResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final UserPostQueueQueryRepository userPostQueueQueryRepository;

    @GetMapping("/{userId}")
    public Response<List<GetPostContentResponseDto>> getPostFeed(@PathVariable(name = "userId") Long userId, Long lastPostId){
        List<GetPostContentResponseDto> result = userPostQueueQueryRepository.getContentResponse(userId, lastPostId);
        return Response.ok(result);
    }
}
