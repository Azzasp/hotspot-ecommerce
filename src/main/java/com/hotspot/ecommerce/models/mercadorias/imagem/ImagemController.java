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


    @GetMapping("/produto")
    public ResponseEntity<List<ImagemProduto>> findImageByProdutoId(@RequestParam Long id_produto){
        return imagemService.findImageByProdutoId(id_produto);
    }

    @DeleteMapping("/produto/{id_produto}/{id_imagem}")
    public ResponseEntity<ImagemProduto> deleteImageByProdutoAndImageId(@PathVariable("id_produto") Long id_produto,
                                                                         @PathVariable("id_imagem") Long id_imagem){
        return imagemService.deleteImageByProdutoAndImageId(id_produto, id_imagem);
    }

    @PostMapping("/produto")
    public ResponseEntity<ImagemProduto> insertProdutoImage(@RequestParam("id_produto") Long id_produto,
                                                            @RequestParam("file") MultipartFile file){
        return imagemService.insertProdutoImage(id_produto, file);
    }


    //Serviços
    @GetMapping("/servico")
    public ResponseEntity<List<ImagemServico>> findImageByServicoId(@RequestParam Long id_servico){
        return imagemService.findImageByServicoId(id_servico);
    }

    @DeleteMapping("/servico/{id_servico}/{id_imagem}")
    public ResponseEntity<ImagemServico> deleteImageByServicoAndImageId(@PathVariable("id_servico") Long id_servico,
                                                                        @PathVariable("id_imagem") Long id_imagem){
        return imagemService.deleteImageByServicoAndImageId(id_servico, id_imagem);
    }

    @PostMapping("/servico")
    public ResponseEntity<ImagemServico> insertServicoImage(@RequestParam("id_service") Long id_servico,
                                                            @RequestParam("file") MultipartFile file){
        return imagemService.insertServicoImage(id_servico, file);
    }
}
