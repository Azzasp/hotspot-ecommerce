package com.hotspot.ecommerce.models.mercadorias.servico.agendamento;

import jakarta.persistence.*;

@Entity
public class Agendamento {
    @Id
    @SequenceGenerator(
            name = "agendamento_sequence",
            sequenceName = "agendamento_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "agendamento_sequence"
    )
    private Long id_agendamento;
}
