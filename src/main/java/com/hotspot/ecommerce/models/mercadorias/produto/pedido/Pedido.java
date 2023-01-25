package com.hotspot.ecommerce.models.mercadorias.produto.pedido;

import jakarta.persistence.*;

@Entity
public class Pedido {
    @Id
    @SequenceGenerator(
            name = "pedido_sequence",
            sequenceName = "pedido_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pedido_sequence"
    )
    private Long id_pedido;
}
