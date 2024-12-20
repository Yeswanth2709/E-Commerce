package com.projects.userservice.services;

import com.projects.userservice.models.User;

public interface UserService {
    User signup(String username, String password, String email) throws Exception;
    User login(String username, String password);

}
