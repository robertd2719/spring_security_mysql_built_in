package com.example.spring_security_jpa_mysql.security;

import com.example.spring_security_jpa_mysql.entities.User;
import com.example.spring_security_jpa_mysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findByUserName(username);

       user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + username));

       return user.map(MyUserDetails::new).get();
    }
}
