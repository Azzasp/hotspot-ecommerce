package com.hotspot.ecommerce.models.mercadorias.imagem;


import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import com.hotspot.ecommerce.models.mercadorias.produto.pedido.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "imagem_produto")
@IdClass(ImagemProduto.ImagemProdutoId.class)
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ImagemProduto {

    @Id
    @ManyToOne(targetEntity = Pedido.class)
    @JoinColumn(name = "id_imagem", referencedColumnName = "id_imagem")
    private Imagem imagem;

    @Id
    @ManyToOne(targetEntity = Produto.class)
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto produto;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class ImagemProdutoId implements Serializable {
        private Imagem imagem;
        private Produto produto;
    }



}
