package com.hotspot.ecommerce.models.usuarios.cliente;

import com.hotspot.ecommerce.models.usuarios.cliente.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@AllArgsConstructor
public class ClienteService{

    private ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;


    public ResponseEntity<ClienteDTO> findById(Long id){
        var cliente = clienteRepository.findById(id).orElse(null);
        return ResponseEntity.ok(clienteMapper.toClienteDTO(cliente));
    }


    public ResponseEntity<ClienteDTO> deleteById(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
