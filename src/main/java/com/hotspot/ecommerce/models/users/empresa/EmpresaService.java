package com.hotspot.ecommerce.models.users.empresa;


import com.hotspot.ecommerce.models.users.empresa.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpresaService {

    private EmpresaRepository empresaRepository;
    private EmpresaMapper empresaMapper;

    public ResponseEntity<EmpresaDTO> findById(Long id){
        var empresa = empresaRepository.findById(id).orElse(null);
        return ResponseEntity.ok(empresaMapper.toEmpresaDTO(empresa));
    }

    public ResponseEntity<EmpresaDTO> deleteById(Long id){
        empresaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
