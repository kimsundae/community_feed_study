package org.fastcampus.acceptance.auth;

import org.fastcampus.acceptance.steps.SignupAcceptanceSteps;
import org.fastcampus.acceptance.utils.AcceptanceTestTemplate;
import org.fastcampus.auth.application.dto.CreateUserAuthRequestDto;
import org.fastcampus.auth.application.dto.SendEmailRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SignupAcceptanceTest extends AcceptanceTestTemplate {

    private final String email = "email@email.com";

    @BeforeEach
    void setup(){
        this.cleanUp();
    }

    @Test
    void givenEmail_whenSendEmail_thenVerificationTokenSaved(){
        // given
        SendEmailRequestDto dto = new SendEmailRequestDto(email);

        //when
        Integer code = SignupAcceptanceSteps.requestSendEmail(dto);

        //then
        String token = this.getEmailToken(email);
        assertNotNull(token);
        assertEquals(0, code);
    }

    @Test
    void givenInvalidEmail_whenEmailSend_thenVerificationTokenNotSaved(){
        // given
        SendEmailRequestDto dto = new SendEmailRequestDto("abcd");

        //when
        Integer code = SignupAcceptanceSteps.requestSendEmail(dto);

        //then
//        String token = this.getEmailToken(email);
//        assertNull(token);
        assertEquals(400, code);
    }

    @Test
    void givenSendEmail_whenVerifyEmail_thenEmailVerified(){
        SignupAcceptanceSteps.requestSendEmail(new SendEmailRequestDto(email));

        String token = getEmailToken(email);
        Integer code = SignupAcceptanceSteps.requestVerifyEmail(email, token);

        boolean isEmailVerified = isEmailVerified(email);
        assertEquals(0, code);
        assertTrue(isEmailVerified);
    }

    @Test
    void givenSendEmail_whenVerifyEmailWithWrongToken_thenEmailNotVerified(){
        SignupAcceptanceSteps.requestSendEmail(new SendEmailRequestDto(email));
        Integer code = SignupAcceptanceSteps.requestVerifyEmail(email, "wrong token");

        boolean isEmailVerified = isEmailVerified(email);
        assertEquals(400, code);
        assertFalse(isEmailVerified);
    }

    @Test
    void givenSendEmailVerified_whenVerifyAgain_thenThrowError(){
        SignupAcceptanceSteps.requestSendEmail(new SendEmailRequestDto(email));

        String token = getEmailToken(email);
        SignupAcceptanceSteps.requestVerifyEmail(email, token);
        Integer code = SignupAcceptanceSteps.requestVerifyEmail(email, token);

        assertEquals(400, code);
    }

    @Test
    void givenSendEmail_whenVerifyEmailWithWrongEmail_thenThrowError(){
        SignupAcceptanceSteps.requestSendEmail(new SendEmailRequestDto(email));

        String token = getEmailToken(email);
        Integer code = SignupAcceptanceSteps.requestVerifyEmail("wrong email", token);

        assertEquals(400, code);
    }

    @Test
    void givenUnverifiedEmail_whenRegister_thenUserRegistered(){
        SignupAcceptanceSteps.requestSendEmail(new SendEmailRequestDto(email));
        String token = getEmailToken(email);
        SignupAcceptanceSteps.requestVerifyEmail(email, token);

        CreateUserAuthRequestDto dto = new CreateUserAuthRequestDto(email, "password", "USER", "name", "profileImageUrl");
        Integer code = SignupAcceptanceSteps.registerUser(dto);

        assertEquals(0, code);
        Long userId = getUserId(email);
        assertEquals(1L, userId);
    }

    @Test
    void givenUnverifiedEmail_whenRegister_thenThrowError(){
        SignupAcceptanceSteps.requestSendEmail(new SendEmailRequestDto(email));

        CreateUserAuthRequestDto dto = new CreateUserAuthRequestDto(email, "password", "USER", "name", "profileImageUrl");
        Integer code = SignupAcceptanceSteps.registerUser(dto);

        assertEquals(400, code);
    }


}
