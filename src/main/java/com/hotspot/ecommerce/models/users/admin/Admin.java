package com.hotspot.ecommerce.models.users.admin;

import com.hotspot.ecommerce.models.users.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements UserDetails {
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    @Column(name = "id_admin")
    private Long id_admin;
    private String username;
    private String senha;
    private String chave_sec;
    private String nome;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private boolean locked;
    private boolean enabled;

    public Admin(String username, String senha, String chave_sec, String nome, UserRole userRole) {
        this.username = username;
        this.senha = senha;
        this.chave_sec = chave_sec;
        this.nome = nome;
        this.userRole = userRole;
    }

    //Implementação do UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return senha;
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
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
