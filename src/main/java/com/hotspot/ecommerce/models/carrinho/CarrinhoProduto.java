package com.hotspot.ecommerce.models.carrinho;

import com.hotspot.ecommerce.models.produto.Produto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "carrinho_produto")
@IdClass(CarrinhoProduto.CarrinhoProdutoId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarrinhoProduto {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_carrinho", referencedColumnName = "id_carrinho")
    private Carrinho carrinho;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto produto;

    @NotNull()
    @Column(name = "quantidade")
    private int quantidade;

    @Embeddable
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    public static class CarrinhoProdutoId implements Serializable {

        private Carrinho carrinho;
        private Produto produto;

        public CarrinhoProdutoId(Carrinho id_carrinho, Produto id_produto) {
            super();
            this.carrinho = id_carrinho;
            this.produto = id_produto;
        }
    }
}



