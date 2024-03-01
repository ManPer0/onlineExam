package com.yry.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Component
public class Login<T> implements UserDetails, Serializable {
    private T userInfo;
    private List<String> permission;
    private List<SimpleGrantedAuthority> authorities;

    public Login(){}
    public Login(LoginR<T> loginR){
        this.userInfo = loginR.getUserInfo();
        this.permission = loginR.getPermission();
    }

    public Login(T userInfo, List<String> permission) {
        this.userInfo = userInfo;
        this.permission = permission;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (!Objects.isNull(authorities)){
            return authorities;
        }
        authorities = new ArrayList<>();
        authorities = permission.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
