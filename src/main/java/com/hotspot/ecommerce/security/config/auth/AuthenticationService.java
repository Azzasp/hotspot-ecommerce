package com.hotspot.ecommerce.security.config.auth;

import com.hotspot.ecommerce.models.endereco.repository.EnderecoRepository;
import com.hotspot.ecommerce.models.usuarios.cliente.Cliente;
import com.hotspot.ecommerce.models.usuarios.cliente.repository.ClienteRepository;
import com.hotspot.ecommerce.models.usuarios.empresa.Empresa;
import com.hotspot.ecommerce.models.usuarios.empresa.repository.EmpresaRepository;
import com.hotspot.ecommerce.models.usuarios.enums.UserRole;
import com.hotspot.ecommerce.models.usuarios.repository.UsuarioRepository;
import com.hotspot.ecommerce.security.config.JwtService;
import com.hotspot.ecommerce.security.config.auth.requests.AuthenticationRequest;
import com.hotspot.ecommerce.security.config.auth.requests.RegisterRequestCliente;
import com.hotspot.ecommerce.security.config.auth.requests.RegisterRequestEmpresa;
import com.hotspot.ecommerce.security.validator.ValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final ValidatorService validatorService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse registerCliente(RegisterRequestCliente request) {

        if(!validatorService.usernameValidator(request.getUsername())) throw new IllegalStateException();
        if(!validatorService.emailValidator(request.getEmail())
           && !validatorService.validateCPF(request.getCPF()))
                throw new IllegalStateException();

        var usuario = new Cliente(request.getUsername(),
                                    passwordEncoder.encode(request.getSenha()),
                                    request.getChave_sec(),
                                    request.getNome(),
                                    request.getEmail(),
                                    request.getTelefone(),
                                    UserRole.Cliente,
                                    request.getCPF(),
                                    request.getAno_nasc(),
                                    request.getEndereco());
        enderecoRepository.save(request.getEndereco());
        usuarioRepository.save(usuario);
        var jwtToken = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerEmpresa(RegisterRequestEmpresa request) {
        if(!validatorService.usernameValidator(request.getUsername())) throw new IllegalStateException();
        if(!validatorService.emailValidator(request.getEmail())
                && !validatorService.validateCNPJ(request.getCNPJ()))
            throw new IllegalStateException();

        var usuario = new Empresa(request.getUsername(),
                passwordEncoder.encode(request.getSenha()),
                request.getChave_sec(),
                request.getNome(),
                request.getEmail(),
                request.getTelefone(),
                UserRole.Empresa,
                request.getCNPJ(),
                request.getEndereco());
        enderecoRepository.save(request.getEndereco());
        usuarioRepository.save(usuario);
        var jwtToken = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        ));

        var usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        var jwtToken = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
