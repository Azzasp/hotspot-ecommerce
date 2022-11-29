package com.hotspot.ecommerce.models.users.cliente;

import com.hotspot.ecommerce.models.endereco.Endereco;
import com.hotspot.ecommerce.models.pagamento.FormatoPagamentoPreferencial;

import java.util.Date;

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

    public ClienteDTO() {
    }

    public ClienteDTO(Long id_cliente, String usuario, String nome, String email, String telefone, String CPF, Date data_nasc, Endereco endereco, FormatoPagamentoPreferencial formatoPagamento) {
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.CPF = CPF;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
        this.formatoPagamento = formatoPagamento;
    }

    public ClienteDTO(Cliente cliente) {
        this.id_cliente = cliente.getId_cliente();
        this.usuario = cliente.getUsuario();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.CPF = cliente.getCPF();
        this.data_nasc = cliente.getData_nasc();
        this.endereco = cliente.getEndereco();
        this.formatoPagamento = cliente.getFormatoPagamento();
    }
}
