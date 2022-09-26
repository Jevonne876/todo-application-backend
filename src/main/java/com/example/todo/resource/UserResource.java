package com.example.todo.resource;

import com.example.todo.model.User;
import com.example.todo.service.UserService;
import com.example.todo.utility.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/")
public class UserResource {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserResource(UserService userService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;

        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = "post/register-new-user")
    public User registerUser(@RequestBody User user) {
        return userService.register(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getPassword());
    }
}
