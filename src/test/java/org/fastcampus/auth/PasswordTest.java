package org.fastcampus.auth;

import org.fastcampus.auth.domain.Password;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PasswordTest {

    @Test
    void givenPassword_whenMatchSamePassword_thenReturnTrue(){
        Password password = Password.createEncryptPassword("password");

        Assertions.assertTrue(password.matchPassword("password"));
    }

    @Test
    void givenPassword_whenMatchDiffPassword_thenReturnTrue(){
        Password password = Password.createEncryptPassword("password1");

        Assertions.assertFalse(password.matchPassword("password"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenPasswordIsNull_thenThrowError(String password){
        Assertions.assertThrows(IllegalArgumentException.class, () -> Password.createEncryptPassword(null));
    }
}
