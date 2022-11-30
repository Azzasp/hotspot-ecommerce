package com.hotspot.ecommerce.models.users.cliente.repository;

import com.hotspot.ecommerce.models.users.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Optional<Cliente> findByUsername(String username);
}
