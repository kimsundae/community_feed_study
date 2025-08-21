package org.fastcampus.auth;

import org.fastcampus.auth.domain.RandomTokenGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomTokenGeneratorTest {

    @Test
    void whenGenerateToken_thenReturnTokenWithCorrectLength(){
        String token = RandomTokenGenerator.generateToken();

        Assertions.assertNotNull(token);
        Assertions.assertEquals(16, token.length());
    }

    @Test
    void whenGenerateToken_thenReturnTokenWithValidCharacters(){
        String token = RandomTokenGenerator.generateToken();

        Assertions.assertTrue(token.matches("^[a-zA-Z0-9]{16}"));
    }

    @Test
    void whenGenerateToken_thenReturnTokenWithValidCharactors(){
        String token1 = RandomTokenGenerator.generateToken();
        String token2 = RandomTokenGenerator.generateToken();

        Assertions.assertNotNull(token1);
        Assertions.assertNotNull(token2);
        Assertions.assertNotEquals(token1, token2);
    }
}
