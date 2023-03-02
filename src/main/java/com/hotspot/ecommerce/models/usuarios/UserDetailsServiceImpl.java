package com.hotspot.ecommerce.models.usuarios;

import com.hotspot.ecommerce.models.usuarios.cliente.Cliente;
import com.hotspot.ecommerce.models.usuarios.cliente.repository.ClienteRepository;
import com.hotspot.ecommerce.models.usuarios.empresa.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsServiceImpl implements UserDetailsService {

    private ClienteRepository clienteRepository;
    private EmpresaRepository empresaRepository;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente user = clienteRepository.findByUsername(username).get();

        if(user == null)
            throw new UsernameNotFoundException(username);


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }




}
