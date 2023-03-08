package com.hotspot.ecommerce.models.usuarios.empresa.repository;

import com.hotspot.ecommerce.models.usuarios.Usuario;
import com.hotspot.ecommerce.models.usuarios.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findByUsername(@NonNull String username);

    Optional<Empresa> findByEmail(@NonNull String email);

    @Transactional
    @Modifying
    @Query("update Empresa e set e.senha = ?1 where e.id_usuario = ?2")
    void updatePassword(@NonNull String senha, @NonNull Long id_usuario);



    @Query("select (count(e) > 0) from Empresa e where e.email like ?1")
    boolean existEmail(@NonNull String email);

    @Query("select (count(e) > 0) from Empresa e where e.username like ?1")
    boolean existUsername(@NonNull String username);




}
