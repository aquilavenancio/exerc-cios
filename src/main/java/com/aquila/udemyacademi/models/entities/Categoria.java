package com.aquila.udemyacademi.models.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id", "nome"})
public class Categoria implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    private Set<Produto> produtos = new HashSet<>();

}
