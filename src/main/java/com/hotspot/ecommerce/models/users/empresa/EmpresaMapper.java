package com.hotspot.ecommerce.models.users.empresa;

import com.hotspot.ecommerce.models.users.cliente.Cliente;
import com.hotspot.ecommerce.models.users.cliente.ClienteDTO;
import com.hotspot.ecommerce.models.users.cliente.EmpresaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmpresaMapper {

    protected ModelMapper modelMapper = new ModelMapper();

    //Mapeando o objeto Cliente em ClienteDTO
    public EmpresaDTO toEmpresaDTO(Empresa empresa){
        return modelMapper.map(empresa, EmpresaDTO.class);
    }
    //Mapeando o objeto ClienteDTO em Cliente
    public Empresa toEmpresa(EmpresaDTO empresaDTO){
        return modelMapper.map(empresaDTO, Empresa.class);
    }


    //Mapeando uma lista utilizando o método toClienteDTO

    public List<EmpresaDTO> toListEmpresaDTO (List<Empresa> empresa){
        return empresa.stream()
                .map(this::toEmpresaDTO)
                .collect(Collectors.toList());
    }

    public List<Empresa> toListEmpresa (List<EmpresaDTO> empresa){
        return empresa.stream()
                .map(this::toEmpresa)
                .collect(Collectors.toList());
    }
}
