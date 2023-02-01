package com.hotspot.ecommerce.models.mercadorias.imagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Imagem extends JpaRepository<Imagem, Long> {
}
