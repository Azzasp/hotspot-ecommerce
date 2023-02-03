package com.hotspot.ecommerce.models.mercadorias.imagem.repository;

import com.hotspot.ecommerce.models.mercadorias.imagem.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
