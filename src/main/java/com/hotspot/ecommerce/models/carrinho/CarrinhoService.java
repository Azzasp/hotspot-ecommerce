package com.hotspot.ecommerce.models.carrinho;

import com.hotspot.ecommerce.models.carrinho.repository.CarrinhoProdutoRepository;
import com.hotspot.ecommerce.models.carrinho.repository.CarrinhoRepository;
import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import com.hotspot.ecommerce.models.mercadorias.produto.ProdutoDTO;
import com.hotspot.ecommerce.models.mercadorias.produto.ProdutoMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoService {

    private Carrinho carrinho;
    private CarrinhoRepository carrinhoRepository;
    private ProdutoMapper produtoMapper;
    private CarrinhoProdutoRepository carrinhoProdutoRepository;

    public ResponseEntity<List<ProdutoDTO>> findAllProdutos(Carrinho carrinho){
        List<Produto> listaProdutos = carrinhoProdutoRepository.findAllProdutosFromCarrinho(carrinho.getId_carrinho());
        List<ProdutoDTO> listaProdutosDTO = listaProdutos.stream().map(produtoMapper::toProdutoDTO).toList();
        return ResponseEntity.ok(listaProdutosDTO);
    }

    public ResponseEntity<ProdutoDTO> addProdutoToCarrinho(Carrinho carrinho, Produto produto, int quantidade){
        carrinhoRepository.save(carrinho);
        carrinho.getCarrinhoProdutos().add(new CarrinhoProduto(carrinho, produto, quantidade));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<ProdutoDTO> deleteProdutoCarrinho(Produto produto, Carrinho carrinho){
        carrinhoProdutoRepository.deleteByProdutoId(produto.getId_produto(), carrinho.getId_carrinho());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<Carrinho> deleteAllProdutosFromCarrinho(Carrinho carrinho){
        carrinhoProdutoRepository.deleteAllProdutos(carrinho.getId_carrinho());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
