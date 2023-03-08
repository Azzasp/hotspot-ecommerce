package com.hotspot.ecommerce.models.usuarios.cliente.repository;

import com.hotspot.ecommerce.models.usuarios.Usuario;
import com.hotspot.ecommerce.models.usuarios.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Optional<Cliente> findByUsername(@NonNull String username);

    Optional<Cliente> findByEmail(@NonNull String email);

    @Modifying
    @Query("update Cliente c set c.senha = ?1 where c.id_usuario = ?2")
    void updatePassword(@NonNull String senha, @NonNull Long id_usuario);



    @Query("select (count(c) > 0) from Cliente c where c.email like ?1")
    boolean existEmail(@NonNull String email);

    @Query("select (count(c) > 0) from Cliente c where c.username like ?1")
    boolean existUsername(@NonNull String username);






}
