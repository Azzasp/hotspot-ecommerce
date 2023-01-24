package com.hotspot.ecommerce.models.carrinho.repository;

import com.hotspot.ecommerce.models.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}
