package com.hotspot.ecommerce.models.mercadorias.imagem;

import com.hotspot.ecommerce.models.mercadorias.imagem.repository.ImagemProdutoRepository;
import com.hotspot.ecommerce.models.mercadorias.imagem.repository.ImagemRepository;
import com.hotspot.ecommerce.models.mercadorias.imagem.repository.ImagemServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagemService {
    private final ImagemRepository imagemRepository;
    private final ImagemProdutoRepository imagemProdutoRepository;
    private final ImagemServicoRepository imagemServicoRepository;

    public ResponseEntity<ImagemProduto> insertProdutoImage(ImagemProduto imagemProduto){
        imagemRepository.save(imagemProduto.getImagem());
        imagemProdutoRepository.save(imagemProduto);
        return ResponseEntity.ok().body(imagemProduto);
    }

    public ResponseEntity<ImagemServico> insertServicoImage(ImagemServico imagemServico){
        imagemRepository.save(imagemServico.getImagem());
        imagemServicoRepository.save(imagemServico);
        return ResponseEntity.ok().body(imagemServico);
    }

    public ResponseEntity<List<ImagemProduto>> findAllProdutosImage(){
        return ResponseEntity.ok().body(imagemProdutoRepository.findAll());
    }

    public ResponseEntity<List<ImagemServico>> findAllServicoImage(){
        return ResponseEntity.ok().body(imagemServicoRepository.findAll());
    }

    public ResponseEntity<List<ImagemProduto>> findImageByProdutoId(Long id){
        return ResponseEntity.ok().body(imagemProdutoRepository.findAllProdutoImageById(id));
    }

    public ResponseEntity<List<ImagemServico>> findImageByServicoId(Long id){
        return ResponseEntity.ok().body(imagemServicoRepository.findAllServicoImageById(id));
    }

    public ResponseEntity<ImagemProduto> deleteImageByProdutoAndImageId(ImagemProduto imagemProduto){
        imagemProdutoRepository.
                deleteProdutoImageById(
                        imagemProduto.getImagem().getId_imagem(),
                        imagemProduto.getProduto().getId_produto());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    public ResponseEntity<ImagemProduto> deleteImageByProdutoAndImageId(ImagemServico servico){
        imagemServicoRepository.
                deleteServicoImageById(
                        servico.getImagem().getId_imagem(),
                        servico.getServico().getId_servico());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
