package com.hotspot.ecommerce.models.mercadorias.imagem.repository;

import com.hotspot.ecommerce.models.mercadorias.imagem.ImagemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ImagemServicoRepository extends JpaRepository<ImagemServico, Long> {
    @Query("SELECT servico FROM ImagemServico img WHERE img.servico = :id_servico")
    List<ImagemServico> findAllServicoImageById(Long id_servico);


    @Query("DELETE FROM ImagemServico img WHERE img.imagem = :id_imagem AND img.servico = :id_servico")
    @Transactional
    @Modifying
    void deleteServicoImageById(Long id_imagem, Long id_servico);

    @Query("SELECT imagem FROM ImagemServico img WHERE img.servico = :id_servico AND img.imagem = :id_imagem")
    ImagemServico findEspecificImageById(Long id_servico, Long id_imagem);
}
