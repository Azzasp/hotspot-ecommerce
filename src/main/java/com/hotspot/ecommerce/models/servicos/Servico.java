package com.hotspot.ecommerce.models.servicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servico")
@AllArgsConstructor
@NoArgsConstructor
public class Servico {
    @SequenceGenerator(
            name = "servico_sequence",
            sequenceName = "servico_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "servico_sequence"
    )
    private String id_servico;
    private String nome;
    private String descricao;
    private Double valor;
    private Status status;
}
