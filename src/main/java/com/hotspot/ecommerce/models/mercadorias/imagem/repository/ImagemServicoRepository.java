package com.hotspot.ecommerce.models.mercadorias.imagem.repository;

import com.hotspot.ecommerce.models.mercadorias.imagem.ImagemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemServicoRepository extends JpaRepository<ImagemServico, Long> {
}
