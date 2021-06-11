package com.fatec.carro.dto;

import com.fatec.carro.model.Carro;
import com.fatec.carro.model.TipoCarro;

public class CarroDTO {

    private String modelo;

    private String marca;

    private String cor;

    private TipoCarro tipo;

    public CarroDTO() {
    }

    public CarroDTO(Carro carro) {
        this.modelo = carro.getModelo();
        this.marca = carro.getMarca();
        this.cor = carro.getCor();
        this.tipo = carro.getTipo();
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