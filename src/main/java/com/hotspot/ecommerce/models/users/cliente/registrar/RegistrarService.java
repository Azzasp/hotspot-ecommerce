package com.hotspot.ecommerce.models.users.cliente.registrar;

import com.hotspot.ecommerce.models.users.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarService {

    private EmailValidator emailValidator;

    public String registrar(Cliente request){
        boolean isEmailValid = emailValidator.test(request.getEmail());
        if(!isEmailValid)
            throw new IllegalStateException(
                    String.format("Email %s não é valido",request.getEmail()));
        return "está funcionando";
    }
}
