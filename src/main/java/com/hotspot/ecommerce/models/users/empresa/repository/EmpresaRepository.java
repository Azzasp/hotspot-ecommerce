package com.hotspot.ecommerce.models.users.empresa.repository;

import com.hotspot.ecommerce.models.users.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
