package com.example.todo.service.implementation;

import com.example.todo.model.User;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImplementation implements UserService, UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public User register(String firstName, String lastName, String username, String email, String password) {
        return null;
    }


}
