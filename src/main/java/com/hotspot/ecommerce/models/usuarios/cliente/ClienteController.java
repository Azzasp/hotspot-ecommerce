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
    @GetMapping(path = "/")
    public ResponseEntity<ClienteDTO> findAccount(@RequestParam Long id){
        return clienteService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<ClienteDTO> updateAccount(@RequestBody ClienteDTO cliente){
        return clienteService.updateAccount(cliente);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id){
        return clienteService.deleteById(id);
    }

}
