package com.hotspot.ecommerce.models.mercadorias.produto.pedido;

import com.hotspot.ecommerce.models.endereco.Endereco;
import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PedidoProduto")
@IdClass(PedidoProduto.PedidoProdutoID.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoProduto{

    @Id
    @ManyToOne(targetEntity = Pedido.class)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;
    private Date data_pedido;
    private int quantidade;
    private Double valor_total;

    @OneToOne
    private Endereco endereco;

    @Id
    @ManyToOne(targetEntity = Produto.class)
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto produto;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class PedidoProdutoID implements Serializable{
        private Pedido pedido;
        private Produto produto;
    }
}
