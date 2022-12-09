package com.hotspot.ecommerce.models.carrinho;

import com.hotspot.ecommerce.models.produto.Produto;
import com.hotspot.ecommerce.models.servicos.Servico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carrinho {
    @Id
    @SequenceGenerator(name = "carrinho_sequence",
            sequenceName = "carrinho_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "carrinho_sequence")
    private Long id_carrinho;
    @ManyToMany
    private Servico servico;
    @ManyToMany
    private Produto produto;

    private List<Servico> carrinhoServico;
    private List<Produto> carrinhoProduto;


}
