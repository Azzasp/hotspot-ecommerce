package com.hotspot.ecommerce.models.mercadorias.servico;

import com.hotspot.ecommerce.models.endereco.Endereco;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class AgendamentoServico {

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
    private Long id_agendamentoServico;
    private Date data_agendamento;
    private Double valor_total;

    @Enumerated(EnumType.STRING)
    private Estado estado_agendamento;
    @OneToOne
    private Endereco endereco_entrega;
    @OneToOne
    private Servico servico;



}
