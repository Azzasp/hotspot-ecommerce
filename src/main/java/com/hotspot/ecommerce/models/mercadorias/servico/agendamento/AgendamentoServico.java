package com.hotspot.ecommerce.models.mercadorias.servico.agendamento;

import com.hotspot.ecommerce.models.endereco.Endereco;
import com.hotspot.ecommerce.models.mercadorias.servico.Estado;
import com.hotspot.ecommerce.models.mercadorias.servico.Servico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AgendamentoServico")
@IdClass(AgendamentoServico.AgendamentoServicoID.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgendamentoServico {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_agendamento", referencedColumnName = "id_agendamento")
    private Agendamento agendamento;
    private Date data_agendamento;
    private Double valor_total;

    @Enumerated(EnumType.STRING)
    private Estado estado_agendamento;
    @OneToOne
    private Endereco endereco_entrega;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")
    private Servico servico;

    public static class AgendamentoServicoID implements Serializable {
        private Agendamento agendamento;
        private Servico servico;
    }


}
