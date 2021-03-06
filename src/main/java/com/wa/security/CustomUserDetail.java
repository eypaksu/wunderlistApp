package com.wa.security;

import com.wa.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {

    private String userName;
    private String password;
    Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetail(User byUsername) {
       this.userName = byUsername.getUsername();
       this.password = byUsername.getPassword();

       List<GrantedAuthority> auths = new ArrayList<>();
//       for(Role role : byUsername.getRoles()){
//            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
//       }
//
       this.authorities = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
