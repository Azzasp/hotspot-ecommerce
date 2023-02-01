package com.hotspot.ecommerce.models.usuarios.admin.repository;

import com.hotspot.ecommerce.models.usuarios.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
