package com.hotspot.ecommerce.security.config.auth;

import com.hotspot.ecommerce.models.email.Email;
import com.hotspot.ecommerce.models.email.EmailService;
import com.hotspot.ecommerce.models.usuarios.Usuario;
import com.hotspot.ecommerce.models.usuarios.cliente.repository.ClienteRepository;
import com.hotspot.ecommerce.models.usuarios.empresa.repository.EmpresaRepository;
import com.hotspot.ecommerce.models.usuarios.enums.UserRole;
import com.hotspot.ecommerce.security.config.JwtService;
import com.hotspot.ecommerce.security.config.auth.requests.UpdatePasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UpdateAccountDataService {

    private final EmpresaRepository empresaRepository;
    private final ClienteRepository clienteRepository;
    private final EmailService emailService;
    private final JwtService jwtService;

    public AuthenticationResponse updatePassword(UpdatePasswordRequest request){
        if(!request.getPassword().equals(request.getNewPassword())) throw new IllegalStateException();

        var usuario = clienteRepository.findByEmail(request.getEmail()).isEmpty() ?
                empresaRepository.findByEmail(request.getEmail()).get() :
                clienteRepository.findByEmail(request.getEmail()).get();
        if(usuario.getTipoUsuario().equals(UserRole.Empresa))
            empresaRepository.updatePassword(request.getPassword(), usuario.getId_usuario());
        else
            clienteRepository.updatePassword(request.getPassword(), usuario.getId_usuario());

        var jwtToken = jwtService.generateToken(usuario);

        emailService.enviarEmailTexto(new Email(usuario.getEmail(), "Alterar Senha - Hotspot",
                "Senha alterada com sucesso!"));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();


    }
    public void sendUpdatePasswordEmail(Usuario usuario){
        String message = "Prezado(a),"+
                "<br> <br>" +
                "Este é um e-mail de confirmação para informar que a sua senha foi alterada com sucesso. \n" +
                "<br>" +
                "Se você não reconhece esta atividade, entre em contato com o nosso suporte imediatamente.\n" +
                "<br> <br>" +
                "Atenciosamente,<br>" +
                "HotSpot - Ecommerce";
        String titulo = "Confirmação de Alteração de Senha";

        Map<String, Object> map = new HashMap<>();
        map.put("nome", usuario.getNome());
        map.put("mensagem", message);

        emailService.enviarEmailTemplate(new Email(usuario.getEmail(), titulo, message), map);
    }


}
