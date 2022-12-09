package com.hotspot.ecommerce.models.users.empresa;

import com.hotspot.ecommerce.models.produto.Produto;
import com.hotspot.ecommerce.models.servicos.Servico;
import com.hotspot.ecommerce.models.users.UserRole;
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
@Table(name = "empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa implements UserDetails {
    @Id
    @SequenceGenerator(name = "empresa_sequence",
            sequenceName = "empresa_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "empresa_sequence")
    private Long id_empresa;
    private String username;
    private String nome;
    private String senha;
    private String chave_sec;
    private String nomeEmpresa;
    private String email;
    private String telefone;
    private String CNPJ;
    @ManyToMany
    private Servico servico;
    @ManyToMany
    private Produto produtos;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private boolean locked;
    private boolean enabled;


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
