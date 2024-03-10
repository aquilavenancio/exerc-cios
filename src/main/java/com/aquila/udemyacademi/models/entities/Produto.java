package com.aquila.udemyacademi.models.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, of =  {"id", "nome", "preco"})
public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nome;
    private Double preco;
    private Categoria categoria;

}
