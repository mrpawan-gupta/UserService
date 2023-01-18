package com.example.user.service.Services.Impl;

import com.example.user.service.Entities.User;
import com.example.user.service.Exceptions.ResourceNotFoundException;
import com.example.user.service.Repository.UserRepository;
import com.example.user.service.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id id not found " + userId));
    }

    @Override
    public User updateUserInformation(User user) {
        try {
            User checkUser = getUserById(user.getId());
            checkUser.setPhone(user.getPhone());
            checkUser.setPassword(user.getPassword());
            return saveUser(checkUser);
        }
        catch (ResourceNotFoundException resourceNotFoundException){
            return saveUser(user);
        }
    }

}
