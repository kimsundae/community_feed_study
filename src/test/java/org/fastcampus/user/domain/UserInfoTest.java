package org.fastcampus.user.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class UserInfoTest {
    @Test
    void givenNameAndProfileImage_whenCreated_thenThrowNoting(){
        //given
        String name = "abcd";
        String profileImageUrl = "";
        //when
        UserInfo userInfo = new UserInfo(name, profileImageUrl);
        //then
        assertDoesNotThrow(()-> new UserInfo(name,profileImageUrl));
    }
}
