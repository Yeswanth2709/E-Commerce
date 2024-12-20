package com.projects.userservice.services;

import com.projects.userservice.models.User;
import com.projects.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public User signup(String username, String password, String email) throws Exception {
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        if (optionalUser.isPresent()) {
            throw new Exception("User already present");
        }
        User user = new User();
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setName(username);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        return null;
    }
}
