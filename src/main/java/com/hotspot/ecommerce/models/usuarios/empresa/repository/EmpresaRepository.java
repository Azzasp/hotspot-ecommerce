package com.hotspot.ecommerce.models.usuarios.empresa.repository;

import com.hotspot.ecommerce.models.usuarios.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("select (count(e) > 0) from Empresa e where e.CNPJ like ?1")
    boolean validateCnpj(@NonNull String CNPJ);

}
