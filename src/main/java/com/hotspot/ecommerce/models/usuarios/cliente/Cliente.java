package com.hotspot.ecommerce.models.usuarios.cliente;



import com.hotspot.ecommerce.models.endereco.Endereco;
import com.hotspot.ecommerce.models.usuarios.Usuario;
import com.hotspot.ecommerce.models.usuarios.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends Usuario{

    public Cliente(String username, String senha, String chave_sec, String nome, String email, String telefone, UserRole tipoUsuario, String CPF, Year ano_nasc) {
        super(username, senha, chave_sec, nome, email, telefone, tipoUsuario);
        this.CPF = CPF;
        this.ano_nasc = ano_nasc;
    }

    @Column(unique = true)
    private String CPF;
    private Year ano_nasc;


}
