package com.hotspot.ecommerce.models.carrinho.repository;

import com.hotspot.ecommerce.models.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
