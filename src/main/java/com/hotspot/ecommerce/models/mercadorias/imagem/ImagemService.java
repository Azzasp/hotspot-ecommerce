package com.hotspot.ecommerce.models.mercadorias.imagem;

import com.hotspot.ecommerce.models.mercadorias.imagem.repository.ImagemProdutoRepository;
import com.hotspot.ecommerce.models.mercadorias.imagem.repository.ImagemRepository;
import com.hotspot.ecommerce.models.mercadorias.imagem.repository.ImagemServicoRepository;
import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import com.hotspot.ecommerce.models.mercadorias.produto.repository.ProdutoRepository;
import com.hotspot.ecommerce.models.mercadorias.servico.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagemService {
    private final ProdutoRepository produtoRepository;
    private final ServicoRepository servicoRepository;
    private final ImagemRepository imagemRepository;
    private final ImagemProdutoRepository imagemProdutoRepository;
    private final ImagemServicoRepository imagemServicoRepository;

    public ResponseEntity<ImagemProduto> insertProdutoImage(Long id_produto, MultipartFile file){
        var produto = produtoRepository.findById(id_produto).get();
        var produtoImagem = new ImagemProduto();

        try{
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String imagemNome = String.valueOf(produto.getId_produto()) + file.getOriginalFilename();
                Path path = Paths.get("C:/imagens/" + imagemNome);
                Files.write(path, bytes);
                produtoImagem.setNome(imagemNome);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        produtoImagem.setProduto(produto);

        return ResponseEntity.ok().body(imagemProdutoRepository.save(produtoImagem));
    }

    public ResponseEntity<ImagemServico> insertServicoImage(Long id_servico, MultipartFile file){
        var servico = servicoRepository.findById(id_servico).get();
        var servicoImagem = new ImagemServico();

        try{
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String imagemNome = String.valueOf(servico.getId_servico()) + file.getOriginalFilename();
                Path path = Paths.get("C:/imagens/" + imagemNome);
                Files.write(path, bytes);
                servicoImagem.setNome(imagemNome);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        servicoImagem.setServico(servico);

        return ResponseEntity.ok().body(imagemServicoRepository.save(servicoImagem));
    }

    public ResponseEntity<List<ImagemProduto>> findImageByProdutoId(Long id){
        return ResponseEntity.ok().body(imagemProdutoRepository.findAllProdutoImageById(id));
    }

    public ResponseEntity<List<ImagemServico>> findImageByServicoId(Long id){
        return ResponseEntity.ok().body(imagemServicoRepository.findAllServicoImageById(id));
    }

    public ResponseEntity<ImagemProduto> deleteImageByProdutoAndImageId(Long id_produto,
                                                                        Long id_imagem){
        imagemProdutoRepository.
                deleteProdutoImageById(id_produto, id_imagem);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    public ResponseEntity<ImagemServico> deleteImageByServicoAndImageId(Long id_servico,
                                                                        Long id_imagem){
        imagemServicoRepository.
                deleteServicoImageById(id_servico, id_imagem);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
