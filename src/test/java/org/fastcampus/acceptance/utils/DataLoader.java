package org.fastcampus.acceptance.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.fastcampus.user.application.dto.CreateuserRequestDto;
import org.fastcampus.user.application.dto.FollowUserRequestDto;
import org.springframework.stereotype.Component;
import static org.fastcampus.acceptance.steps.UserAcceptanceSteps.createUser;
import static org.fastcampus.acceptance.steps.UserAcceptanceSteps.followUser;

@Component
public class DataLoader {

    @PersistenceContext
    private EntityManager entityManager;

    public void loadData(){
        CreateuserRequestDto dto = new CreateuserRequestDto("test user", "");
        createUser(dto);
        createUser(dto);
        createUser(dto);

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

}
