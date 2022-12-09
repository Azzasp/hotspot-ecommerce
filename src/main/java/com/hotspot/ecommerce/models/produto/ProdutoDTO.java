package com.hotspot.ecommerce.models.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
    private Long id_produto;
    private String nome;
    private String descricao;
    private Double valor;
}
