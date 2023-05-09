package com.hotspot.ecommerce.models.usuarios.empresa;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/empresa")
@AllArgsConstructor
public class EmpresaController {

    private EmpresaService empresaService;

    @GetMapping(path = "/")
    public ResponseEntity<EmpresaDTO> findById(@RequestParam Long id){
        return empresaService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<EmpresaDTO> updateAccount(@RequestBody EmpresaDTO empresa){
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<EmpresaDTO> deleteAccount(@PathVariable Long id){
        return empresaService.deleteById(id);
    }

}
