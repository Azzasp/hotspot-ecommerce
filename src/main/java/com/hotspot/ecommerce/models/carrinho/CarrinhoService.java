package com.hotspot.ecommerce.models.carrinho;

import com.hotspot.ecommerce.models.carrinho.repository.CarrinhoRepository;
import com.hotspot.ecommerce.models.produto.ProdutoDTO;
import com.hotspot.ecommerce.models.produto.ProdutoMapper;
import com.hotspot.ecommerce.models.servicos.ServicoDTO;
import com.hotspot.ecommerce.models.servicos.ServicoMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoService {

    private Carrinho carrinho;
    private CarrinhoRepository carrinhoRepository;
    private ProdutoMapper produtoMapper;
    private ServicoMapper servicoMapper;

    public ResponseEntity<ProdutoDTO> addProdutoToCarrinho(Long id){
        //carrinhoRepository.addProdutoToCarrinho(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<ServicoDTO> addServicoToCarrinho(Long id){
        //carrinhoRepository.addServicoToCarrinho(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    public ResponseEntity<ServicoDTO> deleteServicoCarrinho(Long id){
        //carrinhoRepository.deleteServicoById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<ProdutoDTO> deleteProdutoCarrinho(Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
