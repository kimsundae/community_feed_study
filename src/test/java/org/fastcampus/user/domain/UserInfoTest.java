package org.fastcampus.user.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @Test
    void givenBlankNameAndProfileImage_whenCreated_thenThrowNoting(){
        //given
        String name = "";
        String profileImageUrl = "";

        //when
        //then
        assertThrows(IllegalArgumentException.class, ()-> new UserInfo(name,profileImageUrl));
    }
}
