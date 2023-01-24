package com.hotspot.ecommerce.models.usuarios.cliente;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/cliente")
@AllArgsConstructor
@NoArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    //Visualizar perfil
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteDTO> visualizarPerfil(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity excluirCadastro(@PathVariable Long id){
        return clienteService.deleteById(id);
    }

}
