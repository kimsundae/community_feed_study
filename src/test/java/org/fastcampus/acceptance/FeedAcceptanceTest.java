package org.fastcampus.acceptance;

import static org.fastcampus.acceptance.steps.FeedAcceptanceSteps.requestCreatePost;
import static org.fastcampus.acceptance.steps.FeedAcceptanceSteps.requestFeed;

import org.fastcampus.acceptance.utils.AcceptanceTestTemplate;
import org.fastcampus.post.application.dto.CreatePostRequestDto;
import org.fastcampus.post.domain.content.PostPublicationState;
import org.fastcampus.user.ui.dto.GetPostContentResponseDto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FeedAcceptanceTest extends AcceptanceTestTemplate {

    /*
    * User 1 --- follow ---> User2
    * user 1 --- follow ---> User3
    * */
    @BeforeEach
    void setUp(){
        super.init();
    }

    /*
    * User 2 create Post 1
    * User 1 Get Post 1 From Feed
    * */
    @Test
    void givenUserHasFollowerAndCreatePostWhenFollowerUserRequestFeed_thenFollowerCanGetPostFromFeed(){
        // given
        CreatePostRequestDto dto = new CreatePostRequestDto(2L, "user 11 can get this post",
                PostPublicationState.PUBLIC);
        Long createPostId = requestCreatePost(dto);

        //when, 팔로워 피드를 요청
        List<GetPostContentResponseDto> result = requestFeed(1L);

        // then
        assertEquals(1, result.size());
        assertEquals(createPostId, result.get(0).getId());
    }
}
