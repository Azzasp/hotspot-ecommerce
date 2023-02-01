package com.hotspot.ecommerce.models.mercadorias.imagem;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "imagens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Imagem {
    @Id
    @SequenceGenerator(name = "imagem_sequence",
            allocationSize = 1,
            sequenceName = "imagem_sequence" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagem_sequence")
    private Long id_imagem;

    @OneToMany(mappedBy = "imagem")
    private List<ImagemProduto> produtos;

    @OneToMany(mappedBy = "servico")
    private List<ImagemServico> servicos;
}
