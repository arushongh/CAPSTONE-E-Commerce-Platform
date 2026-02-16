package com.ecommerce.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private List<User> users = new ArrayList<>();

    private User loggedInUser;

    public void registerUser(User u) {
        users.add(u);
    }
    public void updateUser(User u,User latest) {
        if(users.contains(u)) {
            users.set(users.indexOf(u),latest);
        } else {
            System.out.println(u.getName()+" does not exist");
        }
    }
    public void deleteUser(User u) {
        if(users.contains(u)) {
            users.remove(u);
            System.out.println(u.getName()+" removed successfully");
        }
        else {
            System.out.println(u.getName()+" does not exist");
        }
    }
    public boolean login(String email,String password) {
        Optional<User> user = users.stream().filter(x->(x.getEmail().equalsIgnoreCase(email) && x.getPassword().equals(password))).findFirst();
        if(user.isPresent()) {
            loggedInUser=user.get();
            return true;
        }
        return false;
    }

    public void logout() {
        loggedInUser=null;
    }

    public Optional<User> getLoggedInUser() {
        return Optional.ofNullable(loggedInUser);
    }
}
