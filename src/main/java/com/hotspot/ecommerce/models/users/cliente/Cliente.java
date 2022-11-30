package com.hotspot.ecommerce.models.users.cliente;

import com.hotspot.ecommerce.models.endereco.Endereco;
import com.hotspot.ecommerce.models.pagamento.FormatoPagamentoPreferencial;
import com.hotspot.ecommerce.models.users.role.UserRole;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements UserDetails {

    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence"
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cliente")
    private Long id_cliente;
    private String usuario;
    private String senha;
    private String chave_sec;
    private String nome;
    private String email;
    private String telefone;
    private String CPF;
    private Date data_nasc;
    private Endereco endereco;
    private UserRole userRole;
    private boolean locked;
    private boolean enabled;
    private FormatoPagamentoPreferencial formatoPagamento;

    public Cliente(String usuario, String senha, String chave_sec, String nome, String email, String telefone, String CPF, Date data_nasc, Endereco endereco, UserRole userRole, boolean locked, boolean enabled, FormatoPagamentoPreferencial formatoPagamento) {
        this.usuario = usuario;
        this.senha = senha;
        this.chave_sec = chave_sec;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.CPF = CPF;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
        this.userRole = userRole;
        this.locked = locked;
        this.enabled = enabled;
        this.formatoPagamento = formatoPagamento;
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
        return usuario;
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
