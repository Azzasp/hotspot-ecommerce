package com.hotspot.ecommerce.models.mercadorias.imagem;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/imagem")
@RequiredArgsConstructor
@Data
public class ImagemController {

    private final ImagemService imagemService;


    @GetMapping("/produto/{id_produto}")
    public ResponseEntity<List<ImagemProduto>> findImageByProdutoId(@PathVariable Long id_produto){
        return imagemService.findImageByProdutoId(id_produto);
    }

    @DeleteMapping("/produto/{id_produto}/{id_imagem}")
    public ResponseEntity<ImagemProduto> deleteImageByProdutoAndImageId(@PathVariable Long id_produto,
                                                                         @PathVariable Long id_imagem){
        return imagemService.deleteImageByProdutoAndImageId(id_produto, id_imagem);
    }

    @PostMapping("/produto/{id_produto}")
    public ResponseEntity<ImagemProduto> insertProdutoImage(Long id_produto, MultipartFile file){
        return imagemService.insertProdutoImage(id_produto, file);
    }


    //Serviços
    @GetMapping("/servico/{id_servico}")
    public ResponseEntity<List<ImagemServico>> findImageByServicoId(@PathVariable Long id_servico){
        return imagemService.findImageByServicoId(id_servico);
    }

    @DeleteMapping("/servico/{id_servico}/{id_imagem}")
    public ResponseEntity<ImagemServico> deleteImageByServicoAndImageId(@PathVariable Long id_servico,
                                                                        @PathVariable Long id_imagem){
        return imagemService.deleteImageByServicoAndImageId(id_servico, id_imagem);
    }

    @PostMapping("/servico/{id_produto}")
    public ResponseEntity<ImagemServico> insertServicoImage(Long id_servico, MultipartFile file){
        return imagemService.insertServicoImage(id_servico, file);
    }
}
