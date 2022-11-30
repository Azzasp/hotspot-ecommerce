package com.hotspot.ecommerce.models.users.cliente;

import com.hotspot.ecommerce.models.users.cliente.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService implements UserDetailsService {

    private ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return clienteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Usuario: %s não existe.", username)));
    }

    public ResponseEntity<List<ClienteDTO>> findAll(){
        return ResponseEntity.ok(
                clienteRepository.findAll().stream()
                        .map(clienteMapper::toClienteDTO)
                        .collect(Collectors.toList())
        );
    }

    public ResponseEntity<ClienteDTO> findById(Long id){
        var cliente = clienteRepository.findById(id).orElse(null);
        return ResponseEntity.ok(clienteMapper.toClienteDTO(cliente));
    }

    public ResponseEntity<ClienteDTO> registrarCliente(ClienteDTO clienteDTO){
        var cliente = clienteMapper.toCliente(clienteDTO);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
    }

    public ResponseEntity deleteById(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
