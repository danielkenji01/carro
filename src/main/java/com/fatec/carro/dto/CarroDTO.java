package com.fatec.carro.dto;

import com.fatec.carro.model.Carro;
import com.fatec.carro.model.TipoCarro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarroDTO {

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca;

    @NotBlank
    private String cor;

    @NotNull
    private TipoCarro tipo;

    public CarroDTO() {
    }

    public CarroDTO(Carro carro) {
        this.modelo = carro.getModelo();
        this.marca = carro.getMarca();
        this.cor = carro.getCor();
        this.tipo = carro.getTipo();
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

    public TipoCarro getTipo() {
        return tipo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTipo(TipoCarro tipo) {
        this.tipo = tipo;
    }

    public Carro toCarro(Carro carro) {
        return carro
                .comCor(this.cor)
                .comMarca(this.marca)
                .comModelo(this.modelo)
                .comTipo(this.tipo);
    }

    public Carro toCarro() {
        return new Carro()
                .comCor(this.cor)
                .comMarca(this.marca)
                .comModelo(this.modelo)
                .comTipo(this.tipo);
    }

}