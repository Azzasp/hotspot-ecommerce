package com.hotspot.ecommerce.models.usuarios;

import com.hotspot.ecommerce.models.endereco.Endereco;
import com.hotspot.ecommerce.models.usuarios.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario implements UserDetails {

    @SequenceGenerator(
            name = "usuario_sequence",
            sequenceName = "usuario_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuario_sequence"
    )
    @Column(name = "id_usuario")
    private Long id_usuario;
    @Column(unique = true)
    private String username;
    private String senha;
    private String chave_sec;
    private String nome;
    @Column(unique = true)
    private String email;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private UserRole tipoUsuario;
    @ManyToOne
    @JoinColumn(name = "endereco_id_endereco")
    private Endereco endereco;

    public Usuario(String username, String senha, String chave_sec, String nome, String email, String telefone,UserRole tipoUsuario, Endereco endereco) {
        this.username = username;
        this.senha = senha;
        this.chave_sec = chave_sec;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.endereco = endereco;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authority =
                new SimpleGrantedAuthority(tipoUsuario.name());
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
        return false;
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
