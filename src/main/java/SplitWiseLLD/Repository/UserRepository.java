package SplitWiseLLD.Repository;

import SplitWiseLLD.Models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    Map<String, User> userIdVsUser;
    public UserRepository(){
        userIdVsUser = new HashMap<>();
    }

    public User getUser(String userId){
        return userIdVsUser.get(userId);
    }

    public void addUser(User user){
        userIdVsUser.put(user.getId(), user);
    }

}
