package SplitWiseLLD.Models;

import java.util.Objects;

public class UserPair {
    User user;
    User frnd;
    public UserPair(User user, User frnd){
        this.user = user;
        this.frnd = frnd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFrnd() {
        return frnd;
    }

    public void setFrnd(User frnd) {
        this.frnd = frnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPair userPair = (UserPair) o;
        return Objects.equals(user, userPair.user) && Objects.equals(frnd, userPair.frnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, frnd);
    }
}
