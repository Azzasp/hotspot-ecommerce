package com.hotspot.ecommerce.models.carrinho.repository;

import com.hotspot.ecommerce.models.carrinho.Carrinho;
import com.hotspot.ecommerce.models.produto.Produto;
import com.hotspot.ecommerce.models.produto.ProdutoDTO;
import com.hotspot.ecommerce.models.servicos.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    //Add
    @Modifying
    @Query(value = "INSERT INTO Carrinho produto_id VALUES (?1)")
    Optional<Produto> addProdutoToCarrinho(Long id);

    @Modifying
    @Query(value = "INSERT INTO Carrinho servico_id VALUES (?1)")
    Optional<Servico> addServicoToCarrinho(Long id);

    //Delete
    @Modifying
    @Query("DELETE FROM Carrinho c WHERE c.produto.id_produto = (?1)")
    void deleteProdutoById(Long id);

    @Modifying
    @Query("DELETE FROM Carrinho c WHERE c.servico.id_servico = (?1)")
    void deleteServicoById(Long id);
}
