package com.hotspot.ecommerce.models.usuarios.empresa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmpresaDTO {

    private Long id_empresa;
    private String username;
    private String nome;
    private String senha;
    private String chave_sec;
    private String nomeEmpresa;
    private String email;
    private String telefone;
    private String CNPJ;


    public EmpresaDTO(String username, String senha, String chave_sec, String nomeEmpresa, String email, String telefone, String CNPJ) {
        this.username = username;
        this.senha = senha;
        this.chave_sec = chave_sec;
        this.nomeEmpresa = nomeEmpresa;
        this.email = email;
        this.telefone = telefone;
        this.CNPJ = CNPJ;
    }



}
