package com.hotspot.ecommerce.models.users.cliente;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/cliente")
@AllArgsConstructor
@NoArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping(path = "/registrar")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteDTO clienteDTO){
        return clienteService.registrarCliente(clienteDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity excluirCadastro(@PathVariable Long id){
        return clienteService.deleteById(id);
    }

    @GetMapping
    public String helloworld(){
        return "hello world!";
    }
}
