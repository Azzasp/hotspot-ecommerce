package com.hotspot.ecommerce.models.mercadorias.produto.pedido.repository;

import com.hotspot.ecommerce.models.mercadorias.produto.pedido.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {
}
