package com.hotspot.ecommerce.models.mercadorias.imagem.repository;

import com.hotspot.ecommerce.models.mercadorias.imagem.ImagemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Long> {
}
