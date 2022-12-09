package com.hotspot.ecommerce.models.servicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "servico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private Long id_servico;
    private String nome;
    private String descricao;
    private Double valor;
    private Status status;
}
