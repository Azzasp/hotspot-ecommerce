package com.hotspot.ecommerce.models.mercadorias.servico.agendamento.repository;

import com.hotspot.ecommerce.models.mercadorias.servico.agendamento.AgendamentoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoServicoRepository extends JpaRepository<AgendamentoServico, Long> {
}
