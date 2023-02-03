package com.hotspot.ecommerce.models.mercadorias.categoria.repository;

import com.hotspot.ecommerce.models.mercadorias.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
