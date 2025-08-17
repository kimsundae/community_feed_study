package org.fastcampus.acceptance.auth;

import org.fastcampus.acceptance.steps.SignupAcceptanceSteps;
import org.fastcampus.acceptance.utils.AcceptanceTestTemplate;
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
        String token = this.getEmailToken(email);
        assertNull(token);
        assertEquals(500, code);
    }
}
