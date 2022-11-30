package com.hotspot.ecommerce.models.users.cliente;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component()
public final class ClienteMapper {

    protected ModelMapper modelMapper = new ModelMapper();

    //Mapeando o objeto Cliente em ClienteDTO
    public ClienteDTO toClienteDTO(Cliente cliente){
        return modelMapper.map(cliente, ClienteDTO.class);
    }
    //Mapeando o objeto ClienteDTO em Cliente
    public Cliente toCliente(ClienteDTO cliente){
        return modelMapper.map(cliente, Cliente.class);
    }


    //Mapeando uma lista utilizando o método toClienteDTO

    public List<ClienteDTO> toListClienteDTO (List<Cliente> cliente){
        return cliente.stream()
                .map(this::toClienteDTO)
                .collect(Collectors.toList());
    }

    public List<Cliente> toListCliente (List<ClienteDTO> cliente){
        return cliente.stream()
                .map(this::toCliente)
                .collect(Collectors.toList());
    }





}
