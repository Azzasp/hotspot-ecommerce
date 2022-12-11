package com.hotspot.ecommerce.models.carrinho;

import com.hotspot.ecommerce.models.produto.Produto;
import com.hotspot.ecommerce.models.servicos.Servico;
import com.hotspot.ecommerce.models.users.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "carrinho")
@Getter
@Setter
@AllArgsConstructor
public class Carrinho {
    @Id
    @SequenceGenerator(name = "carrinho_sequence",
            sequenceName = "carrinho_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "carrinho_sequence")
    private Long id_carrinho;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany
    @JoinColumn(name = "servico_id")
    private List<Servico> servicos;

    @OneToMany
    @JoinColumn(name = "produto_id")
    private List<Produto> produtos;

    public Carrinho() {
    }
}
