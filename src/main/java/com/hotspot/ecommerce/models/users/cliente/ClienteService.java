package com.hotspot.ecommerce.models.users.cliente;

import com.hotspot.ecommerce.models.users.cliente.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService implements UserDetailsService {

    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return clienteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Usuario: %s não existe.", username)));
    }

    public UserDetails registrarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
