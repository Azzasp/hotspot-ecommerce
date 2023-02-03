package com.hotspot.ecommerce.models.mercadorias.imagem;


import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "imagem_produto")
@IdClass(ImagemProduto.ImagemProdutoId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImagemProduto {

    @Id
    @ManyToOne(targetEntity = Imagem.class)
    @JoinColumn(name = "id_imagem", referencedColumnName = "id_imagem")
    private Imagem imagem;

    @Id
    @ManyToOne(targetEntity = Produto.class)
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto produto;

    private String nome;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class ImagemProdutoId implements Serializable {
        private Imagem imagem;
        private Produto produto;
    }



}
