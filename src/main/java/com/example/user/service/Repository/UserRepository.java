package com.example.user.service.Repository;

import com.example.user.service.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    /*
     Interface to implement custom method and query including write
     */
}
