package com.example.user.service.Controller;

import com.example.user.service.Entities.User;
import com.example.user.service.Exceptions.ResourceNotFoundException;
import com.example.user.service.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/create/v{version_id}/")
    public ResponseEntity<User> createUser(@PathVariable Integer version_id, @RequestBody User user){
        /*
         * Creates a new user.
         *
         * @param version_id The version of the API being used by the client
         * @param user The user object to be created, passed in through the request body
         * @return A ResponseEntity object with a status of "CREATED" and the new user object as the body,
         *         or a status of "HTTP_VERSION_NOT_SUPPORTED" if the version of the API is not supported
         */
        if(Objects.equals(version_id, 1)) {
            User newUser = userServices.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }else {
            return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).build();
        }
    }

    @GetMapping("/get/v{version_id}/")
    public ResponseEntity<User> getSingleUser(@PathVariable Integer version_id, @RequestParam(value = "id", defaultValue = "0") Integer user_id){
        /*
         * Retrieves a single user by id.
         *
         * @param version_id The version of the API being used by the client
         * @param user_id The id of the user to be retrieved, passed in through the request param
         * @return A ResponseEntity object with a status of HttpStatus.OK and the user object as the body,
         *         or a status of HttpStatus.HTTP_VERSION_NOT_SUPPORTED if the version of the API is not supported
         */
        if(Objects.equals(version_id, 1)) {
            User newUser = userServices.getUserById(user_id);
            return ResponseEntity.ok(newUser);
        }else{
            return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).build();
        }
    }

    @GetMapping("/list/v{version_id}/")
    public ResponseEntity<List<User>> getAllUser(@PathVariable Integer version_id){
        /*
         * Retrieves a list of all users.
         *
         * @param version_id The version of the API being used by the client
         * @return A ResponseEntity object with a status of HttpStatus.OK and the list of all users as the body,
         *         or a status of HttpStatus.HTTP_VERSION_NOT_SUPPORTED if the version of the API is not supported
         */
        if(Objects.equals(version_id, 1)) {
            List<User> userList = userServices.getAllUser();
            return ResponseEntity.ok(userList);
        }else{
            return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).build();
        }
    }

    @PutMapping("/update/v{version_id}/")
    public ResponseEntity<User> UpdateUserInformation(@PathVariable Integer version_id, @RequestBody User user){
        if(Objects.equals(version_id, 1)){
            User updatedUser = userServices.updateUserInformation(user);
            return ResponseEntity.ok(updatedUser);
        }else{
            return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).build();
        }
    }

}
