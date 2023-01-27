package com.hotspot.ecommerce.models.carrinho;


import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import com.hotspot.ecommerce.models.mercadorias.produto.ProdutoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinho")
@AllArgsConstructor
public class CarrinhoController {

    private CarrinhoService carrinhoService;

    @GetMapping("/")
    private ResponseEntity<List<ProdutoDTO>> findAllProdutos(Carrinho carrinho){
        return carrinhoService.findAllProdutos(carrinho);
    }

    @PostMapping("/")
    private ResponseEntity<ProdutoDTO> addProdutoToCarrinho(Produto produto, Carrinho carrinho, int quantidade){
        carrinhoService.addProdutoToCarrinho(carrinho, produto,quantidade);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{produto}/{carrinho}")
    private ResponseEntity<ProdutoDTO> deleteProdutoCarrinho(@PathVariable Produto produto, @PathVariable Carrinho carrinho){
        return carrinhoService.deleteProdutoCarrinho(produto, carrinho);
    }

    @DeleteMapping("/{carrinho}")
    private ResponseEntity<ProdutoDTO> deleteAllProdutos(@PathVariable Carrinho carrinho){
        return carrinhoService.deleteAllProdutosFromCarrinho(carrinho);
    }

}
