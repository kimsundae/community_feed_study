package org.fastcampus.user.domain;

public class User {

    private final Long id;
    private final UserInfo info;
    private final UserRelationCounter followingCounter;
    private final UserRelationCounter followerCounter;

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.info = userInfo;
        this.followingCounter = new UserRelationCounter();
        this.followerCounter = new UserRelationCounter();
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
        if (!super.equals(object)) return false;
        User user = (User) object;
        return java.util.Objects.equals(id, user.id);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id);
    }
}
