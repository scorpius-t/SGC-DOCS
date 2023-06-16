package com.IEC.SGCDOCS.securingweb.modelos.DB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter@Setter
@Entity
@Table(name="usuarios")
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "usr", nullable = false)
    private String username;
    @Column(name = "pswd", nullable = false)
    private String password;
    @Column(name = "rol", nullable = false)
    private String roles;
    @Column(name = "account_non_locked", nullable = false)
    private boolean accountNonLocked;

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {
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
