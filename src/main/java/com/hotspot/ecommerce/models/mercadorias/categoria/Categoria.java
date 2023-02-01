package com.hotspot.ecommerce.models.mercadorias.categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @SequenceGenerator(
            name = "categoria_sequence",
            sequenceName = "categoria_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "categoria_sequence"
    )
    @Column(name = "id_categoria")
    private Long id_categoria;
    private String nome_categoria;
}
