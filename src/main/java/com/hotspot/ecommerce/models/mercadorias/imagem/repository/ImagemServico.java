package com.hotspot.ecommerce.models.mercadorias.imagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemServico extends JpaRepository<ImagemServico, Long> {
}
