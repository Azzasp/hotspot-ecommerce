package com.hotspot.ecommerce.models.users.empresa;


import com.hotspot.ecommerce.models.produto.ProdutoDTO;
import com.hotspot.ecommerce.models.produto.ProdutoMapper;
import com.hotspot.ecommerce.models.produto.repository.ProdutoRepository;
import com.hotspot.ecommerce.models.users.empresa.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@Service
@AllArgsConstructor
public class EmpresaService {

    private EmpresaRepository empresaRepository;
    private EmpresaMapper empresaMapper;
    private ProdutoRepository produtoRepository;
    private ProdutoMapper produtoMapper;

    //Empresa
    public ResponseEntity<EmpresaDTO> findById(Long id){
        var empresa = empresaRepository.findById(id).orElseThrow(new NotFound());
        return ResponseEntity.ok(empresaMapper.toEmpresaDTO(empresa));
    }

    public ResponseEntity<EmpresaDTO> deleteById(Long id){
        empresaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Produto
    public ResponseEntity<ProdutoDTO> cadastrarProduto(ProdutoDTO produtoDTO){
        var produto = produtoMapper.toProduto(produtoDTO);
        produtoRepository.save(produto);
        return ResponseEntity.ok(produtoDTO);
    }

    public ResponseEntity<ProdutoDTO> findProdutoById(Long id){
        // TODO: create Exception
        return ResponseEntity.ok(produtoRepository.findById(id).orElseThrow(new NotFound()));
    }

    public ResponseEntity<ProdutoDTO> alterarProduto(ProdutoDTO produtoDTO){
        produtoRepository.save(produtoMapper.toProduto(produtoDTO));
        return ResponseEntity.ok(produtoDTO);
    }

    public ResponseEntity<ProdutoDTO> deletarProduto(Long id){
        produtoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Serviço
    


}
