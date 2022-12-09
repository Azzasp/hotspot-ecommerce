package com.hotspot.ecommerce.models.users.admin;

import com.hotspot.ecommerce.models.users.cliente.ClienteDTO;
import com.hotspot.ecommerce.models.users.empresa.EmpresaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/admin")
@AllArgsConstructor
public class AdminController {

    private AdminService adminService;

    @GetMapping(name = "/cliente")
    public ResponseEntity<List<ClienteDTO>> todosCliente (){
        return adminService.findAllCliente();
    }

    @GetMapping(name = "/cliente/{id}")
    public ResponseEntity<ClienteDTO> encontrarCliente(@PathVariable Long id){
        return adminService.findClienteBydId(id);
    }

    @DeleteMapping(name = "/cliente/{id}")
    public ResponseEntity<ClienteDTO> deletarCliente(@PathVariable Long id){
        return adminService.deleteClienteById(id);
    }

    @GetMapping(name = "/empresa")
    public ResponseEntity<List<EmpresaDTO>> todasEmpresas(){
        return adminService.findAllEmpresa();
    }

    @GetMapping(name = "/empresa/{id}")
    public ResponseEntity<EmpresaDTO> encontrarEmpresa(@PathVariable Long id){
        return adminService.findEmpresaBydId(id);
    }
    @DeleteMapping(name = "/empresa/{id}")
    public ResponseEntity<EmpresaDTO> deletarEmpresa(@PathVariable Long id){
        return adminService.deleteEmpresaById(id);
    }
}
