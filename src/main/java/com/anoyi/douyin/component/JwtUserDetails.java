package com.anoyi.douyin.component;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.anoyi.douyin.entity.Role;
import com.anoyi.douyin.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUserDetails implements UserDetails {

	private static final long serialVersionUID = -6384768461024285611L;
	private User user;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(User user) {
        this.user = user;
        List<Role> roles = user.getRoles();
        this.authorities = mapToGrantedAuthorities(roles);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRoleName()))
                .collect(Collectors.toList());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonIgnore
    public Long getId() {
        return Long.valueOf(user.getId());
    }

    @Override
    public String getUsername() {
        return String.valueOf(user.getId());
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return user.getEnable() == 1;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return user.getLastUpdatePwdTime();
    }
}
