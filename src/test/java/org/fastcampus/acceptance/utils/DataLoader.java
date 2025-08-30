package org.fastcampus.acceptance.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.fastcampus.acceptance.steps.SignupAcceptanceSteps;
import org.fastcampus.auth.application.dto.CreateUserAuthRequestDto;
import org.fastcampus.auth.application.dto.SendEmailRequestDto;
import org.fastcampus.user.application.dto.FollowUserRequestDto;
import org.springframework.stereotype.Component;
import static org.fastcampus.acceptance.steps.UserAcceptanceSteps.followUser;

@Component
public class DataLoader {

    @PersistenceContext
    private EntityManager entityManager;

    public void loadData(){
        for(int i=1; i<=3; i++){
            createUser("user"+i+"@test.com");
        }

        followUser(new FollowUserRequestDto(1L, 2L));
        followUser(new FollowUserRequestDto(1L, 3L));
    }

    public String getEmailToken(String email){
        return entityManager.createNativeQuery("SELECT token FROM community_email_verification WHERE email = ?", String.class)
                .setParameter(1, email)
                .getSingleResult()
                .toString();
    }

    public boolean isEmailVerified(String email){
        return entityManager.createQuery("SELECT isVerified FROM EmailVerificationEntity WHERE email = :email", Boolean.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public Long getUserId(String email){
        return entityManager.createQuery("SELECT userId FROM UserAuthEntitiy WHERE email = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public void createUser(String email){
        SignupAcceptanceSteps.requestSendEmail(new SendEmailRequestDto(email));
        String token = getEmailToken(email);
        SignupAcceptanceSteps.requestVerifyEmail(email, token);
        SignupAcceptanceSteps.registerUser(new CreateUserAuthRequestDto(email, "password", "USER","name", ""));
    }

}
