package org.fastcampus.acceptance.auth;

import org.fastcampus.auth.domain.TokenProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TokenProviderTest {

    private final String secretKey = "testtesttesttesttesttesttesttesttesttesttesttesttesttest";
    private final TokenProvider tokenProvider = new TokenProvider(secretKey);

    @Test
    void givenValidUserAndRole_whenCreateToken_thenReturnValidToken(){
        Long userId = 1L;
        String role = "ADMIN";

        String token = tokenProvider.createToken(userId, role);

        assertNotNull(token);
        assertEquals(userId, tokenProvider.getUserId(token));
        assertEquals(role, tokenProvider.getUserRole(token));
    }

    @Test
    void givenInvalidToken_whenGetUserId_thenThrowError(){
        String invalidToken = "invalidToken";

        assertThrows(Exception.class, () -> tokenProvider.getUserId(invalidToken));
    }
}
