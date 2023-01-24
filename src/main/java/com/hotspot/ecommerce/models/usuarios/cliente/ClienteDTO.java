package com.hotspot.ecommerce.models.usuarios.cliente;

import com.hotspot.ecommerce.models.endereco.Endereco;
import com.hotspot.ecommerce.models.pagamento.FormatoPagamentoPreferencial;
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
    private FormatoPagamentoPreferencial formatoPagamento;

    public ClienteDTO(String usuario, String nome, String email, String telefone, String CPF, Date data_nasc, Endereco endereco, FormatoPagamentoPreferencial formatoPagamento) {
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.CPF = CPF;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
        this.formatoPagamento = formatoPagamento;
    }

    /*
        "Prototype" // iria copiar o Cliente em ClienteDTO, mas ja temos o ClienteMapper
    public ClienteDTO(Cliente cliente) {
        this.id_cliente = cliente.getId_cliente();
        this.usuario = cliente.getUsername();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.CPF = cliente.getCPF();
        this.data_nasc = cliente.getData_nasc();
    }*/


}
