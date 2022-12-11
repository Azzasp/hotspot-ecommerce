package com.hotspot.ecommerce.models.produto;


import com.hotspot.ecommerce.models.carrinho.Carrinho;
import com.hotspot.ecommerce.models.users.empresa.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "produtos")
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
    @OneToOne
    private Empresa empresa;
    @OneToMany(targetEntity = Carrinho.class,fetch = FetchType.LAZY,mappedBy = "produtos")
    private List<Carrinho> carrinho;
}
