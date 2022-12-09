package com.hotspot.ecommerce.models.users.registrar;

import com.hotspot.ecommerce.models.users.cliente.ClienteDTO;
import com.hotspot.ecommerce.models.users.cliente.ClienteMapper;
import com.hotspot.ecommerce.models.users.cliente.repository.ClienteRepository;
import com.hotspot.ecommerce.models.users.empresa.EmpresaDTO;
import com.hotspot.ecommerce.models.users.empresa.EmpresaMapper;
import com.hotspot.ecommerce.models.users.empresa.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarService {

    private EmailValidator emailValidator;
    private ClienteMapper clienteMapper;
    private ClienteRepository clienteRepository;
    private EmpresaRepository empresaRepository;
    private EmpresaMapper empresaMapper;


    public ResponseEntity<ClienteDTO> registrarCliente(ClienteDTO clienteDTO){
        var cliente = clienteMapper.toCliente(clienteDTO);
        clienteRepository.save(cliente);
        boolean isEmailValid = emailValidator.test(clienteDTO.getEmail());
        if(!isEmailValid)
            throw new IllegalStateException(
                    String.format("Email %s não é valido",clienteDTO.getEmail()));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
    }

    public ResponseEntity<EmpresaDTO> registrarEmpresa(EmpresaDTO empresaDTO){
        var empresa = empresaMapper.toEmpresa(empresaDTO);
        empresaRepository.save(empresa);
        boolean isEmailValid = emailValidator.test(empresaDTO.getEmail());
        if(!isEmailValid)
            throw new IllegalStateException(
                    String.format("Email %s não é valido",empresaDTO.getEmail()));
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaDTO);
    }
}
