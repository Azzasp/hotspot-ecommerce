package com.hotspot.ecommerce.models.usuarios.cliente;

import com.hotspot.ecommerce.models.usuarios.cliente.repository.ClienteRepository;
import com.hotspot.ecommerce.models.usuarios.registrar.RegistrarService;
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
public class ClienteService implements UserDetailsService {

    private ClienteRepository clienteRepository;
    private RegistrarService registrarService;
    private final ClienteMapper clienteMapper;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return clienteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Usuario: %s não existe.", username)));
    }

    public ResponseEntity<ClienteDTO> findById(Long id){
        var cliente = clienteRepository.findById(id).orElse(null);
        return ResponseEntity.ok(clienteMapper.toClienteDTO(cliente));
    }

    public ResponseEntity<ClienteDTO> registrarCliente(ClienteDTO clienteDTO){
        return registrarService.registrarCliente(clienteDTO);
    }

    public ResponseEntity deleteById(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
