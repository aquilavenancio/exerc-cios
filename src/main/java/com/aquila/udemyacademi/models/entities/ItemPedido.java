package com.aquila.udemyacademi.models.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemPedido implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private Produto produto;
    private Pedido pedido;
    private Integer quantidade;
    private Double preco;
}
