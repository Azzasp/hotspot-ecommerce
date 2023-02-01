package com.hotspot.ecommerce.models.usuarios.cliente.repository;

import com.hotspot.ecommerce.models.usuarios.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Optional<Cliente> findByUsername(String username);

    @Query("select (count(c) > 0) from Cliente c where c.CPF like ?1")
    boolean validateCpf(String CPF);


}
