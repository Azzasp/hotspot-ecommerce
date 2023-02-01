package com.hotspot.ecommerce.models.usuarios.empresa;

import com.hotspot.ecommerce.models.endereco.Endereco;
import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import com.hotspot.ecommerce.models.mercadorias.servico.Servico;
import com.hotspot.ecommerce.models.usuarios.Usuario;
import com.hotspot.ecommerce.models.usuarios.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends Usuario {

    public Empresa(String username, String senha, String chave_sec, String nome, String email, String telefone, UserRole tipoUsuario, String CNPJ, Endereco endereco) {
        super(username, senha, chave_sec, nome, email, telefone, tipoUsuario, endereco);
        this.CNPJ = CNPJ;
    }

    @Column(unique = true)
    private String CNPJ;


}
