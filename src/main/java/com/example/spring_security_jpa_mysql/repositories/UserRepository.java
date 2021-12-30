package com.example.spring_security_jpa_mysql.repositories;

import com.example.spring_security_jpa_mysql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // we need to include the following
    Optional<User> findByUserName(String userName);
}
