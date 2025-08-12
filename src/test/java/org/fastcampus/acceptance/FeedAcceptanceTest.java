package org.fastcampus.acceptance;

import org.fastcampus.acceptance.steps.FeedAcceptanceSteps;
import org.fastcampus.acceptance.utils.AcceptanceTestTemplate;
import org.fastcampus.post.application.dto.CreatePostRequestDto;
import org.fastcampus.post.domain.content.PostPublicationState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void givenUserHasFollowerWhenFollowingUserCreatePost_thenFollowerCanGetPostFromFeed(){
        // given
        CreatePostRequestDto dto = new CreatePostRequestDto(2L, "user 11 can get this post",
                PostPublicationState.PUBLIC);
        Long createPostId = FeedAcceptanceSteps.requestCreatePost(dto);
    }
}
