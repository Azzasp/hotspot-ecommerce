package com.hotspot.ecommerce.models.usuarios.admin;

import com.hotspot.ecommerce.models.usuarios.cliente.ClienteDTO;
import com.hotspot.ecommerce.models.usuarios.empresa.EmpresaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
@AllArgsConstructor
public class AdminController {

    private AdminService adminService;

    @GetMapping(value = "/cliente")
    public ResponseEntity<List<ClienteDTO>> findAllClientes (){
        return adminService.findAllCliente();
    }

    @GetMapping(value = "/cliente/{id}")
    public ResponseEntity<ClienteDTO> findClienteById(@PathVariable Long id){
        return adminService.findClienteBydId(id);
    }

    @DeleteMapping(value = "/cliente/{id}")
    public ResponseEntity<ClienteDTO> deleteClienteById(@PathVariable Long id){
        return adminService.deleteClienteById(id);
    }

    @GetMapping(value = "/empresa")
    public ResponseEntity<List<EmpresaDTO>> findAllEmpresas(){
        return adminService.findAllEmpresa();
    }

    @GetMapping(value = "/empresa/{id}")
    public ResponseEntity<EmpresaDTO> findEmpresasById(@PathVariable Long id){
        return adminService.findEmpresaBydId(id);
    }
    @DeleteMapping(value = "/empresa/{id}")
    public ResponseEntity<EmpresaDTO> deleteEmpresaById(@PathVariable Long id){
        return adminService.deleteEmpresaById(id);
    }
}
