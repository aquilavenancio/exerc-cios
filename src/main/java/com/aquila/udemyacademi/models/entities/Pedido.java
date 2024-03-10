package com.aquila.udemyacademi.models.entities;

import static jakarta.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pedido")
@Data
@EqualsAndHashCode(callSuper = false, of = {"id", "instante"})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TIMESTAMP)
    private Date instante;
}
