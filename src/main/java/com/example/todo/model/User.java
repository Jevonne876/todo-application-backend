package com.example.todo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "user")
@Getter
@Setter
@ToString
public class User implements Serializable {
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(nullable = false, updatable = true, unique = true, length = 36)
    private UUID userID = UUID.randomUUID();
    @Column(nullable = false, updatable = true, unique = false, length = 512)
    private String firstName;
    @Column(nullable = false, updatable = true, unique = false, length = 512)
    private String lastName;
    @Column(nullable = false, updatable = true, unique = true)
    private String email;

    @Column(nullable = false, updatable = true, unique = true, length = 15)
    private String username;

    @Column(nullable = false, updatable = true, unique = true, length = 8)
    private String password;
    private String role;
    private String[] authorities;

    @Column(nullable = false, updatable = true)
    private Boolean isAccountNonExpired;

    @Column(nullable = false, updatable = true)
    private Boolean isAccountNonLocked;

    @Column(nullable = false, updatable = true)
    private Boolean isCredentialsNonExpired;

    @Column(nullable = false, updatable = true)
    private Date updatedAt = new Date();

    @Column(nullable = false, updatable = false)
    private Date createdAt = new Date();

    public User() {
    }

    public User(Long id, UUID userID, String firstName, String lastName, String email, String username, String password, String role, String[] authorities, Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Date updatedAt, Date createdAt) {
        this.id = id;
        this.userID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.authorities = authorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.updatedAt = new Date();
        this.createdAt = new Date();
    }

    public User(String firstName, String lastName, String email, String username, String password, String role, String[] authorities, Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Date updatedAt, Date createdAt) {
        this.userID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.authorities = authorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.updatedAt = new Date();
        this.createdAt = new Date();
    }


}
