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

    @Enumerated(EnumType.STRING)
    private TipoCarro tipo;

    public Carro comModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public Carro comMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public Carro comCor(String cor) {
        this.cor = cor;
        return this;
    }

    public Carro comTipo(TipoCarro tipo) {
        this.tipo = tipo;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public TipoCarro getTipo() {
        return tipo;
    }

}