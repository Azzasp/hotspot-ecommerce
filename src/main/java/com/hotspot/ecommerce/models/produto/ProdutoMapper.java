package com.hotspot.ecommerce.models.produto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoMapper {

    protected ModelMapper modelMapper = new ModelMapper();

    //Mapeando o objeto Cliente em ClienteDTO
    public ProdutoDTO toProdutoDTO(Produto produto){
        return modelMapper.map(produto, ProdutoDTO.class);
    }
    //Mapeando o objeto ClienteDTO em Cliente
    public Produto toProduto(ProdutoDTO produto){
        return modelMapper.map(produto, Produto.class);
    }


    //Mapeando uma lista utilizando o método toClienteDTO

    public List<ProdutoDTO> toListProdutoDTO (List<Produto> produto){
        return produto.stream()
                .map(this::toProdutoDTO)
                .collect(Collectors.toList());
    }

    public List<Produto> toListEmpresa (List<ProdutoDTO> produto){
        return produto.stream()
                .map(this::toProduto)
                .collect(Collectors.toList());
    }
}
