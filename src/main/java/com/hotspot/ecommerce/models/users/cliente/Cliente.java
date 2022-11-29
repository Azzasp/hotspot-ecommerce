package com.hotspot.ecommerce.models.users.cliente;

import com.hotspot.ecommerce.models.endereco.Endereco;
import com.hotspot.ecommerce.models.pagamento.FormatoPagamentoPreferencial;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
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
    private FormatoPagamentoPreferencial formatoPagamento;

    public Cliente() {
    }

    public Cliente(Long id_cliente,
                   String usuario,
                   String senha,
                   String chave_sec,
                   String nome,
                   String email,
                   String telefone,
                   String CPF,
                   Date data_nasc,
                   Endereco endereco) {
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        this.senha = senha;
        this.chave_sec = chave_sec;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.CPF = CPF;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getChave_sec() {
        return chave_sec;
    }

    public void setChave_sec(String chave_sec) {
        this.chave_sec = chave_sec;
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

    public void setFormatoPagamentoPreferencial(FormatoPagamentoPreferencial formatoPagamento) {
        this.formatoPagamento = formatoPagamento;
    }
}
