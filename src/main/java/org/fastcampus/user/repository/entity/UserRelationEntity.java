package org.fastcampus.user.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fastcampus.common.repository.entity.TimeBaseEntity;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="community_user_relation")
@Entity
@IdClass(UserRelationIdEntity.class)
public class UserRelationEntity extends TimeBaseEntity {
    @Id
    private Long followingUserId;

    @Id
    private Long followerUserId;
}
