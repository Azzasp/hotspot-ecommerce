package com.hotspot.ecommerce.models.carrinho.repository;

import com.hotspot.ecommerce.models.carrinho.Carrinho;
import com.hotspot.ecommerce.models.produto.Produto;
import com.hotspot.ecommerce.models.servicos.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}
