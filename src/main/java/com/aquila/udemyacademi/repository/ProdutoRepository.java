package com.aquila.udemyacademi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aquila.udemyacademi.models.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    @Query(value = "from Produto prod where prod.nome = :name")
    Produto findByName(@Param(value = "name") String nome);
    
}
