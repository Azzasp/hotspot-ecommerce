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

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public FormatoPagamentoPreferencial getFormatoPagamento() {
        return formatoPagamento;
    }

    public void setFormatoPagamento(FormatoPagamentoPreferencial formatoPagamento) {
        this.formatoPagamento = formatoPagamento;
    }
}
