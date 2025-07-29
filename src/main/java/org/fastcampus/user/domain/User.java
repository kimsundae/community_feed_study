package org.fastcampus.user.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.fastcampus.common.domain.PositiveIntegerCounter;
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Long id;
    @Embedded
    private UserInfo info;
    @Embedded
    private PositiveIntegerCounter followingCounter;
    @Embedded
    private PositiveIntegerCounter followerCounter;

    public User(Long id, UserInfo userInfo) {
        if(userInfo == null){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.info = userInfo;
        this.followingCounter = new PositiveIntegerCounter();
        this.followerCounter = new PositiveIntegerCounter();
    }

    public void follow(User targetUser){
        if(targetUser.equals(this)){
            throw new IllegalArgumentException();
        }

        followingCounter.increase();
        targetUser.increaseFollowerCount();
    }

    public void unFollow(User targetUser){
        if(targetUser.equals(this)){
            throw new IllegalArgumentException();
        }

        followingCounter.decrease();
        targetUser.decreaseFollowerCount();
    }

    private void increaseFollowerCount(){
        followerCounter.increase();
    }
    private void decreaseFollowerCount(){
        followerCounter.decrease();
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return java.util.Objects.equals(id, user.id);
    }

    public int hashCode() {
        return java.util.Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public int getFollowingCount() {
        return followingCounter.getCount();
    }

    public int getFollowerCount() {
        return followerCounter.getCount();
    }

    public UserInfo getInfo() {
        return info;
    }

    public PositiveIntegerCounter getFollowingCounter() {
        return followingCounter;
    }

    public PositiveIntegerCounter getFollowerCounter() {
        return followerCounter;
    }
    public String getProfileImage() {
        return info.getProfileImageUrl();
    }
    public String getName(){
        return info.getName();
    }
}
