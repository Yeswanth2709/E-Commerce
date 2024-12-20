package com.projects.userservice.controllers;

import com.projects.userservice.dtos.LoginRequestDto;
import com.projects.userservice.dtos.SignUpRequestDto;
import com.projects.userservice.dtos.ValidateTokenRequestDto;
import com.projects.userservice.models.Token;
import com.projects.userservice.models.User;
import com.projects.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequestDto requestDto) {
        try{
            User user = userService.signup(requestDto.getName(), requestDto.getPassword(), requestDto.getEmail());
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody LoginRequestDto requestDto) {
        return null;
    }

    @PostMapping("/validate-token")
    public ResponseEntity<Token> validateToken(@RequestBody ValidateTokenRequestDto requestDto) {
        return null;
    }
}
