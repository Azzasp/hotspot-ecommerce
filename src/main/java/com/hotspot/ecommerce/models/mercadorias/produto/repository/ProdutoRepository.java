package com.hotspot.ecommerce.models.mercadorias.produto.repository;

import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
