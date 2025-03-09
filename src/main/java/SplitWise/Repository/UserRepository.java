package SplitWise.Repository;

import SplitWise.Models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    Map<String, User> userRepo;
    public UserRepository(){
        userRepo = new HashMap<>();
    }

    public void addUser(User user){
        userRepo.put(user.getId(), user);
    }

    public User getUser(String uid){
        return userRepo.get(uid);
    }

    public void removeUser(String uid){
        userRepo.remove(uid);
    }

}
