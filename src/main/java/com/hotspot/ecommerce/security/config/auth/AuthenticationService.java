package com.hotspot.ecommerce.security.config.auth;

import com.hotspot.ecommerce.models.email.Email;
import com.hotspot.ecommerce.models.email.EmailService;
import com.hotspot.ecommerce.models.endereco.repository.EnderecoRepository;
import com.hotspot.ecommerce.models.usuarios.Usuario;
import com.hotspot.ecommerce.models.usuarios.cliente.Cliente;
import com.hotspot.ecommerce.models.usuarios.cliente.repository.ClienteRepository;
import com.hotspot.ecommerce.models.usuarios.empresa.Empresa;
import com.hotspot.ecommerce.models.usuarios.empresa.repository.EmpresaRepository;
import com.hotspot.ecommerce.models.usuarios.enums.UserRole;
import com.hotspot.ecommerce.security.config.JwtService;
import com.hotspot.ecommerce.security.config.auth.requests.AuthenticationRequest;
import com.hotspot.ecommerce.security.config.auth.requests.RegisterRequestCliente;
import com.hotspot.ecommerce.security.config.auth.requests.RegisterRequestEmpresa;
import com.hotspot.ecommerce.security.validator.ValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final EmpresaRepository empresaRepository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final ValidatorService validatorService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthenticationResponse registerCliente(RegisterRequestCliente request) {

        if(!validatorService.usernameValidator(request.getUsername())) throw new IllegalStateException();
        if(!validatorService.emailValidator(request.getEmail())) throw new IllegalStateException();
        if(!validatorService.validateCPF(request.getCPF())) throw new IllegalStateException();

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
        clienteRepository.save(usuario);
        var jwtToken = jwtService.generateToken(usuario);
        sendRegisterEmail(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerEmpresa(RegisterRequestEmpresa request) {
        if(!validatorService.usernameValidator(request.getUsername())) throw new IllegalStateException();
        if(!validatorService.emailValidator(request.getEmail())) throw new IllegalStateException();
        if(!validatorService.validateCNPJ(request.getCNPJ())) throw new IllegalStateException();


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
        empresaRepository.save(usuario);
        var jwtToken = jwtService.generateToken(usuario);
        sendRegisterEmail(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var cliente = clienteRepository.findByUsername(request.getUsername()).isEmpty() ?
                                    empresaRepository.findByUsername(request.getUsername()).orElseThrow() :
                                    clienteRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(cliente);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public void sendRegisterEmail(Usuario usuario){
        String message = "Prezado(a),"+
                "<br> <br>" +
                "Gostaríamos de agradecer por ter se registrado no nosso site Hotspot! Estamos muito felizes em tê-lo(a) como um novo membro da nossa comunidade." +
                "<br>" +
                "A partir de agora, você pode acessar nosso site e desfrutar de todos os recursos que temos a oferecer. Para fazer login, por favor, clique neste link e insira suas informações de login." +
                "<br>" +
                "Mais uma vez, agradecemos pelo seu cadastro e esperamos que você aproveite ao máximo a sua experiência em nosso site!" +
                "<br> <br>" +
                "Atenciosamente,\n" +
                "<br>" +
                "Equipe Hotspot.";
        String titulo = "Cadastro - Hotspot";

        Map<String, Object> map = new HashMap<>();
        map.put("nome", usuario.getNome());
        map.put("mensagem", message);

        emailService.enviarEmailTemplate(new Email(usuario.getEmail(), titulo, message), map);
    }




}
