package org.fastcampus.acceptance.utils;

import org.fastcampus.user.application.dto.CreateuserRequestDto;
import org.fastcampus.user.application.dto.FollowUserRequestDto;
import org.springframework.stereotype.Component;
import static org.fastcampus.acceptance.steps.UserAcceptanceSteps.createUser;
import static org.fastcampus.acceptance.steps.UserAcceptanceSteps.followUser;

@Component
public class DataLoader {

    public void loadData(){
        CreateuserRequestDto dto = new CreateuserRequestDto("test user", "");
        createUser(dto);
        createUser(dto);
        createUser(dto);

        followUser(new FollowUserRequestDto(1L, 2L));
        followUser(new FollowUserRequestDto(1L, 3L));
    }
}
