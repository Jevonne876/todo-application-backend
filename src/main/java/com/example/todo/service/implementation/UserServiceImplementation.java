package com.example.todo.service.implementation;

import com.example.todo.enumeration.Role;
import com.example.todo.model.User;
import com.example.todo.respository.UserRepository;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImplementation implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User register(String firstName, String lastName, String username, String email, String password) {
        User newUser = new User();

        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(encoder.encode(password));
        newUser.setRole(Role.ROLE_ADMIN.name());
        newUser.setAuthorities(Role.ROLE_ADMIN.getAuthorities());
        newUser.setIsAccountNonLocked(true);
        newUser.setIsAccountNonExpired(true);
        newUser.setIsCredentialsNonExpired(true);
        newUser.setUpdatedAt(new Date());
        newUser.setCreatedAt(new Date());
        return this.userRepository.save(newUser);
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
