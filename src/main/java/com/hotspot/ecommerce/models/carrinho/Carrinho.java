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

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Servico.class)
    private List<Servico> carrinhoServico;
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Produto.class)
    private List<Produto> carrinhoProduto;

    public Carrinho() {
    }
}
