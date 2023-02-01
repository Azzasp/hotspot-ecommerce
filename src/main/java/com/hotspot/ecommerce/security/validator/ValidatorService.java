package com.hotspot.ecommerce.security.validator;


import com.hotspot.ecommerce.models.usuarios.cliente.repository.ClienteRepository;
import com.hotspot.ecommerce.models.usuarios.empresa.repository.EmpresaRepository;
import com.hotspot.ecommerce.models.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ValidatorService {

    private final EmpresaRepository empresaRepository;
    private final ClienteRepository clienteRepository;


    public boolean emailValidator(String email){
        if(empresaRepository.existEmail(email) || clienteRepository.existEmail(email)) throw new IllegalStateException();
        String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean usernameValidator(String username){
        if(clienteRepository.existUsername(username)
                || empresaRepository.existUsername(username)) throw new IllegalStateException();
        return true;
    }

    public boolean validateCPF(String input){
        String CPF_REGEX = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";
        Pattern pattern = Pattern.compile(CPF_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public boolean validateCNPJ(String input){
        String CNPJ_REGEX = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$";
        Pattern pattern = Pattern.compile(CNPJ_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
