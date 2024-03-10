package com.aquila.udemyacademi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aquila.udemyacademi.models.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    

    @Query(value = "from Categoria cat where cat.nome = :name ")
    Categoria findByName(@Param(value="name") String name);
}
