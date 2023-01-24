package com.hotspot.ecommerce.models.usuarios.empresa;


import com.hotspot.ecommerce.exceptions.NotFoundException;
import com.hotspot.ecommerce.models.carrinho.CarrinhoService;
import com.hotspot.ecommerce.models.mercadorias.produto.ProdutoDTO;
import com.hotspot.ecommerce.models.mercadorias.produto.ProdutoMapper;
import com.hotspot.ecommerce.models.mercadorias.produto.repository.ProdutoRepository;
import com.hotspot.ecommerce.models.mercadorias.servico.ServicoDTO;
import com.hotspot.ecommerce.models.mercadorias.servico.ServicoMapper;
import com.hotspot.ecommerce.models.mercadorias.servico.repository.ServicoRepository;
import com.hotspot.ecommerce.models.usuarios.empresa.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmpresaService {

    private EmpresaRepository empresaRepository;
    private EmpresaMapper empresaMapper;
    private ProdutoRepository produtoRepository;
    private ProdutoMapper produtoMapper;
    private ServicoRepository servicoRepository;
    private ServicoMapper servicoMapper;
    private CarrinhoService carrinhoService;

    //Empresa as user
    public ResponseEntity<EmpresaDTO> findById(Long id){
        var empresa = empresaRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Não foi possivel localizar %s", id)));
        return ResponseEntity.ok(empresaMapper.toEmpresaDTO(empresa));
    }

    public ResponseEntity<EmpresaDTO> updateEmpresa(EmpresaDTO empresaDTO){
        empresaRepository.save(empresaMapper.toEmpresa(empresaDTO));
        return ResponseEntity.ok(empresaDTO);
    }

    public ResponseEntity<EmpresaDTO> deleteById(Long id){
        empresaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //Adiciona produto/serviço ao Carrinho
    public ResponseEntity<ProdutoDTO> addProdutoToCarrinho(Long id){
        return carrinhoService.addProdutoToCarrinho(id);
    }
    public ResponseEntity<ServicoDTO> addServicoToCarrinho(Long id){
        return carrinhoService.addServicoToCarrinho(id);
    }


    public ResponseEntity<ProdutoDTO> deleteProdutoCarrinho(ProdutoDTO produtoDTO){
        return carrinhoService.deleteProdutoCarrinho(produtoDTO.getId_produto());
    }
    public ResponseEntity<ServicoDTO> deleteServicoCarrinho(ServicoDTO servicoDTO){
        return carrinhoService.deleteServicoCarrinho(servicoDTO.getId_servico());
    }

    //Empresa as owning Produto
    public ResponseEntity<ProdutoDTO> createProduto(ProdutoDTO produtoDTO){
        var produto = produtoMapper.toProduto(produtoDTO);
        produtoRepository.save(produto);
        return ResponseEntity.ok(produtoDTO);
    }

    public ResponseEntity<ProdutoDTO> findProdutoById(Long id){
        var produto = produtoRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Não foi possivel localizar %s", id)));
        return ResponseEntity.ok(produtoMapper.toProdutoDTO(produto));
    }

    public ResponseEntity<ProdutoDTO> updateProduto(ProdutoDTO produtoDTO){
        produtoRepository.save(produtoMapper.toProduto(produtoDTO));
        return ResponseEntity.ok(produtoDTO);
    }

    public ResponseEntity<ProdutoDTO> deleteProdutoById(Long id){
        produtoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




    //Empresa as owning Serviço
    public ResponseEntity<ServicoDTO> createServico(ServicoDTO servicoDTO){
        var produto = servicoMapper.toServico(servicoDTO);
        servicoRepository.save(produto);
        return ResponseEntity.ok(servicoDTO);
    }

    public ResponseEntity<ServicoDTO> findServicoById(Long id){
        var servico = servicoRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Não foi possivel localizar %s", id)));
        return ResponseEntity.ok(servicoMapper.toServicoDTO(servico));
    }

    public ResponseEntity<ServicoDTO> updateServico(ServicoDTO servicoDTO){
        servicoRepository.save(servicoMapper.toServico(servicoDTO));
        return ResponseEntity.ok(servicoDTO);
    }

    public ResponseEntity<ServicoDTO> deleteServicoById(Long id){
        servicoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
