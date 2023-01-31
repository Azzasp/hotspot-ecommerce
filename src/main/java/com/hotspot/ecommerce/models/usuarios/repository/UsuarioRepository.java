package com.hotspot.ecommerce.models.usuarios.repository;

import com.hotspot.ecommerce.models.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT username FROM Usuario u WHERE u.username = :username")
    Optional<Usuario> findByUsername(@NonNull String username);



}
