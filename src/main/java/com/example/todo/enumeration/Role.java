package com.example.todo.enumeration;

import static com.example.todo.constant.Authorities.*;

public enum Role {

    ROLE_USER(USER_AUTHORITIES),
    ROLE_ADMIN(ADMIN_AUTHORITIES);
    private final String[] authorities;
    Role(String... userAuthorities) {
        this.authorities = userAuthorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }

}
