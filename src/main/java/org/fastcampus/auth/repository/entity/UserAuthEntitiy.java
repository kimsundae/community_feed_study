package org.fastcampus.auth.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fastcampus.auth.domain.UserAuth;
import org.fastcampus.common.repository.entity.TimeBaseEntity;

@Entity
@Table(name="community_user_auth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserAuthEntitiy extends TimeBaseEntity {

    @Id
    private String email;
    private String password;
    private String role;
    private Long userId;

    public UserAuthEntitiy(UserAuth userAuth, Long userId) {
        this.email = userAuth.getEmail();
        this.password = userAuth.getPassword();
        this.role = userAuth.getUserRole();
        this.userId = userId;
    }

    public UserAuth toUserAuth(){
        return new UserAuth(email,password,role,userId);
    }
}
