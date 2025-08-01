package org.fastcampus.user.repository.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UserRelationIdEntity {
    private Long follwingUserId;
    private Long followerUserId;
}
