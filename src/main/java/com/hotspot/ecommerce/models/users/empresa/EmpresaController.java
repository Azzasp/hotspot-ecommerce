package com.hotspot.ecommerce.models.users.empresa;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/empresa")
@AllArgsConstructor
public class EmpresaController {

    private EmpresaService empresaService;

    // Visualizar perfil empresa
    @GetMapping(path = "/{id}")
    public ResponseEntity<EmpresaDTO> findById(@PathVariable Long id){
        return empresaService.findById(id);
    }

    // excluir cadastro da empresa
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<EmpresaDTO> excluirCadastro(@PathVariable Long id){
        return empresaService.deleteById(id);
    }

}
