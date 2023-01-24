package com.hotspot.ecommerce.models.usuarios.admin;

import com.hotspot.ecommerce.models.usuarios.cliente.Cliente;
import com.hotspot.ecommerce.models.usuarios.cliente.ClienteDTO;
import com.hotspot.ecommerce.models.usuarios.cliente.ClienteMapper;
import com.hotspot.ecommerce.models.usuarios.cliente.repository.ClienteRepository;
import com.hotspot.ecommerce.models.usuarios.empresa.Empresa;
import com.hotspot.ecommerce.models.usuarios.empresa.EmpresaDTO;
import com.hotspot.ecommerce.models.usuarios.empresa.EmpresaMapper;
import com.hotspot.ecommerce.models.usuarios.empresa.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;
    private EmpresaRepository empresaRepository;
    private EmpresaMapper empresaMapper;

    //Cliente
    public ResponseEntity<ClienteDTO> findClienteBydId(Long id){
        var cliente = clienteRepository.findById(id).orElse(null);
        return ResponseEntity.ok(clienteMapper.toClienteDTO(cliente));
    }

    public ResponseEntity<List<ClienteDTO>> findAllCliente(){
        List<Cliente> listaCliente = clienteRepository.findAll();
        List<ClienteDTO> listaClienteDTO = listaCliente.stream().map(clienteMapper::toClienteDTO).collect(Collectors.toList());
        return ResponseEntity.ok(listaClienteDTO);
    }

    public ResponseEntity<ClienteDTO> deleteClienteById(Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Empresa

    public ResponseEntity<EmpresaDTO> findEmpresaBydId(Long id){
        var empresa = empresaRepository.findById(id).orElse(null);
        return ResponseEntity.ok(empresaMapper.toEmpresaDTO(empresa));
    }

    public ResponseEntity<List<EmpresaDTO>> findAllEmpresa(){
        List<Empresa> listaEmpresa = empresaRepository.findAll();
        List<EmpresaDTO> listaEmpresaDTO = listaEmpresa.stream().map(empresaMapper::toEmpresaDTO).toList();
        return ResponseEntity.ok(listaEmpresaDTO);
    }

    public ResponseEntity<EmpresaDTO> deleteEmpresaById(Long id){
        empresaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
