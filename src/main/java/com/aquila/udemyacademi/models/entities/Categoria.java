package com.aquila.udemyacademi.models.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "categoria")
@Data
@EqualsAndHashCode(of = {"id", "nome"})
public class Categoria implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", length = 120, nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private Set<Produto> produtos = new HashSet<>();

}
