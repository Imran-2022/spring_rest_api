package com.example.restapi.service;

import com.example.restapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1,"Ida", 32, "ida@mail.com");
        User user2 = new User(2,"Hans", 26, "hans@mail.com");
        User user3 = new User(3,"Lars", 45, "lars@mail.com");
        User user4 = new User(4,"Ben", 32, "ben@mail.com");
        User user5 = new User(5,"Eva", 59, "eva@mail.com");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public List<User> getAllUsers() {
        return userList;
    }
    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user: userList) {
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
    public User createUser(User user) {
        userList.add(user);
        return user;
    }
    public void updateUser(User user) {
        // Since the user list is in-memory, there's no need to explicitly update.
        // Any modifications made in the controller will be reflected in the list.
    }

    public boolean deleteUser(Integer id) {
        return userList.removeIf(user -> user.getId() == id);
    }
}
