package com.hotspot.ecommerce.models.mercadorias.produto;


import com.hotspot.ecommerce.models.carrinho.CarrinhoProduto;
import com.hotspot.ecommerce.models.mercadorias.categoria.Categoria;
import com.hotspot.ecommerce.models.mercadorias.produto.pedido.PedidoProduto;
import com.hotspot.ecommerce.models.usuarios.empresa.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {

    @Id
    @SequenceGenerator(name = "produto_sequence", sequenceName = "produto_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_sequence")
    private Long id_produto;
    private String nome;
    private String descricao;
    private Double valor;
    private int quantidade_disponivel;

    @ManyToOne
    private Empresa empresa;

    @ManyToMany
    @JoinTable(name = "CategoriaProduto",
    joinColumns = @JoinColumn(name = "id_produto"),
    inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<Categoria> categoria;

    @OneToMany(mappedBy = "produto")
    private List<CarrinhoProduto> carrinhoProdutos;

    @ManyToOne()
    private PedidoProduto pedidoProdutos;


}
