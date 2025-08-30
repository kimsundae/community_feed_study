package org.fastcampus.acceptance.auth;

import static org.fastcampus.acceptance.steps.LoginAcceptanceSteps.requestLoginGetResponseCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fastcampus.acceptance.steps.LoginAcceptanceSteps;
import org.fastcampus.acceptance.utils.AcceptanceTestTemplate;
import org.fastcampus.auth.application.dto.LoginRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginAcceptanceTest extends AcceptanceTestTemplate {
    private final String email = "email@email.com";

    @BeforeEach
    void setUp(){
        this.cleanUp();
        this.createUser(email);
    }

    @Test
    void givenEmailAndPassword_whenLogin_thenReturnToken(){
        LoginRequestDto dto = new LoginRequestDto(email, "password");

        String token = LoginAcceptanceSteps.requestLoginGetToken(dto);

        Assertions.assertNotNull(token);
    }

    @Test
    void givenEmailAndWrongPassword_whenLogin_thenReturnCodeNotZero(){
        LoginRequestDto dto = new LoginRequestDto(email, "wrong password");

        Integer code = requestLoginGetResponseCode(dto);

        assertEquals(400, code);
    }
}
