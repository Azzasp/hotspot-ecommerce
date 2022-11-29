package com.hotspot.ecommerce.models.users.cliente.repository;

import com.hotspot.ecommerce.models.users.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
