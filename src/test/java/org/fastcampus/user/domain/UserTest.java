package org.fastcampus.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private final UserInfo userInfo = new UserInfo("test", "");
    private User user1;
    private User user2;

    @BeforeEach
    void init(){
        user1 = new User(1L, userInfo);
        user2 = new User(2L, userInfo);
    }

    @Test
    void givenTwoUser_whenEqual_thenReturnFalse(){
        //when
        boolean value = user1.equals(user2);

        //then
        Assertions.assertFalse(value);
    }
    @Test
    void givenTwoSameIdUser_whenEqual_thenRetrunTrue(){
        //given
        User sameUser = new User(1L, userInfo);

        //when
        boolean isSame = user1.equals(sameUser);

        //then
        Assertions.assertTrue(isSame);
    }
    @Test
    void givenTwouser_whenHashCode_thenNotEqual(){
        //when
        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();

        //then
        Assertions.assertNotEquals(hashCode1, hashCode2);
    }
    @Test
    void givenTwoSameIdUser_whenHashCode_thenEqual(){
        //when
        User sameUser = new User(1L, userInfo);

        //when
        int hashCode1 = user1.hashCode();
        int sameUserHashCode = sameUser.hashCode();

        // then
        Assertions.assertEquals(hashCode1,  sameUserHashCode);
    }

    @Test
    void givenTwoUser_whenUser1FollowUser2_thenIncreaseUserCount(){
        //when
        user1.follow(user2);

        //then
        Assertions.assertEquals(1, user1.getFollowingCount());
        Assertions.assertEquals(0, user1.getFollowerCount());
        Assertions.assertEquals(0, user2.getFollowingCount());
        Assertions.assertEquals(1, user2.getFollowerCount());
    }

    @Test
    void givenTwoUserUser1FollowUser2_whenUnfollow_thenDecreaseUserCount(){
        //given
        user1.follow(user2);

        //when
        user1.unFollow(user2);

        //then
        Assertions.assertEquals(0, user1.getFollowingCount());
        Assertions.assertEquals(0, user1.getFollowerCount());
        Assertions.assertEquals(0, user2.getFollowingCount());
        Assertions.assertEquals(0, user2.getFollowerCount());
    }

    @Test
    void givenTwoUser_whenUnfollow_thenNotDecreaseUserCount(){

        //when
        user1.unFollow(user2);

        //then
        Assertions.assertEquals(0, user1.getFollowingCount());
        Assertions.assertEquals(0, user1.getFollowerCount());
        Assertions.assertEquals(0, user2.getFollowingCount());
        Assertions.assertEquals(0, user2.getFollowerCount());
    }
}
