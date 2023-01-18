package com.example.user.service.Services;

import com.example.user.service.Entities.User;

import java.util.List;

public interface UserServices {
    /*
    Interface for User operations
    */
    User saveUser(User user);

    List<User> getAllUser();

    User getUserById(Integer userId);

    User updateUserInformation(User user);
}
