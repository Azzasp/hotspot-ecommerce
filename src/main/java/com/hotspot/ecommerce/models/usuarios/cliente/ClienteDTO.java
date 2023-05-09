package com.hotspot.ecommerce.models.usuarios.cliente;

import com.hotspot.ecommerce.models.endereco.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private Long id_cliente;
    private String usuario;
    private String nome;
    private String email;
    private String telefone;
    private String CPF;
    private Date data_nasc;
    private Endereco endereco;

    public ClienteDTO(String usuario, String nome, String email, String telefone, String CPF, Date data_nasc, Endereco endereco) {
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.CPF = CPF;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
    }


}
