package com.hotspot.ecommerce.models.users.registrar;

import com.hotspot.ecommerce.models.users.cliente.ClienteDTO;
import com.hotspot.ecommerce.models.users.empresa.EmpresaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/registrar")
@AllArgsConstructor
public class RegistrarController {

    private RegistrarService registrarService;


    //Registrando clientes
    @PostMapping(path = "/cliente")
    public ResponseEntity<ClienteDTO> registrarCliente(ClienteDTO clienteDTO){
        return registrarService.registrarCliente(clienteDTO);
    }

    //Registrando Empresas
    @PostMapping(path = "/empresa")
    public ResponseEntity<EmpresaDTO> registrarEmpresa(EmpresaDTO empresaDTO){
        return registrarService.registrarEmpresa(empresaDTO);
    }
}
