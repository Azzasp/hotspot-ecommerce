package com.hotspot.ecommerce.models.mercadorias.imagem.repository;

import com.hotspot.ecommerce.models.mercadorias.imagem.ImagemProduto;
import com.hotspot.ecommerce.models.mercadorias.imagem.ImagemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Long> {
    @Query("SELECT produto FROM ImagemProduto img WHERE img.produto = :id_produto")
    List<ImagemProduto> findAllProdutoImageById(Long id_produto);

    @Query("DELETE FROM ImagemProduto img WHERE img.imagem = :id_imagem AND img.produto = :id_produto")
    @Transactional
    @Modifying
    void deleteProdutoImageById(Long id_imagem, Long id_produto);

    @Query("SELECT imagem FROM ImagemProduto img WHERE img.produto = :id_produto AND img.imagem = :id_imagem")
    ImagemProduto findEspecificImageById(Long id_produto, Long id_imagem);
}
