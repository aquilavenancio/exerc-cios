package com.aquila.udemyacademi.models.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, of = {"id", "instante"})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate instante;
}
