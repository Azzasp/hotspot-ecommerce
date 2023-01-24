package com.hotspot.ecommerce.models.usuarios.empresa.repository;

import com.hotspot.ecommerce.models.usuarios.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
