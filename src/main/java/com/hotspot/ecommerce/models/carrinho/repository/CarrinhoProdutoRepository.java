package com.hotspot.ecommerce.models.carrinho.repository;

import com.hotspot.ecommerce.models.carrinho.Carrinho;
import com.hotspot.ecommerce.models.carrinho.CarrinhoProduto;
import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CarrinhoProdutoRepository extends JpaRepository<CarrinhoProduto, Carrinho>{

    @Modifying
    @Transactional
    @Query("DELETE FROM CarrinhoProduto p where p.produto = :id_produto AND p.carrinho = :id_carrinho")
    void deleteByProdutoId (Long id_produto, Long id_carrinho);

    @Modifying
    @Transactional
    @Query("DELETE FROM CarrinhoProduto p WHERE p.carrinho = :id_carrinho")
    void deleteAllProdutos (Long id_carrinho);

    @Query("SELECT produto FROM CarrinhoProduto cp WHERE cp.carrinho = :id_carrinho")
    List<Produto> findAllProdutosFromCarrinho(Long id_carrinho);


}