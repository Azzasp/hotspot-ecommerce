package com.hotspot.ecommerce.security.config;

import com.hotspot.ecommerce.models.usuarios.Usuario;
import com.hotspot.ecommerce.models.usuarios.cliente.repository.ClienteRepository;
import com.hotspot.ecommerce.models.usuarios.empresa.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final ClienteRepository clienteRepository;
    private final EmpresaRepository empresaRepository;



    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                /*
                * #################
                * Operador Ternário no return
                * #################
                *
                * Verifica se existe retorno no findByUsername, caso tenha retorna cliente
                * se não retorna empresa;
                *
                *
                * */
                return clienteRepository.findByUsername(username).isEmpty() ?
                    empresaRepository.findByUsername(username).orElseThrow() :
                    clienteRepository.findByUsername(username).orElseThrow();
            }
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
