package com.hotspot.ecommerce.security.config.auth.requests;


import com.hotspot.ecommerce.models.usuarios.enums.UserRole;
import lombok.*;

import java.time.Year;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestCliente {

    private String username;
    private String senha;
    private String chave_sec;
    private String nome;
    private String email;
    private String telefone;
    private UserRole tipoUsuario;
    private String CPF;
    private Year ano_nasc;

}
