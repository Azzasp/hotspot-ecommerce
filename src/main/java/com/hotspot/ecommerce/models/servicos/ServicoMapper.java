package com.hotspot.ecommerce.models.servicos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ServicoMapper {

    protected ModelMapper modelMapper = new ModelMapper();

    //Mapeando o objeto Cliente em ClienteDTO
    public ServicoDTO toServicoDTO(Servico servico){
        return modelMapper.map(servico, ServicoDTO.class);
    }
    //Mapeando o objeto ClienteDTO em Cliente
    public Servico toServico(ServicoDTO servicoDTO){
        return modelMapper.map(servicoDTO, Servico.class);
    }


    //Mapeando uma lista utilizando o método toClienteDTO

    public List<ServicoDTO> toListServicoDTO (List<Servico> servicos){
        return servicos.stream()
                .map(this::toServicoDTO)
                .collect(Collectors.toList());
    }

    public List<Servico> toListServico (List<ServicoDTO> servicoDTOS){
        return servicoDTOS.stream()
                .map(this::toServico)
                .collect(Collectors.toList());
    }
}
