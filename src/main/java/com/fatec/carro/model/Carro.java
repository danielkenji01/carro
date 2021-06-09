package com.fatec.carro.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private String marca;

    private String cor;

    private Date dataCriacao;

    private String tipo;

}