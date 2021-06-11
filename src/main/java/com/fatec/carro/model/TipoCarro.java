package com.fatec.carro.model;

public enum TipoCarro {

    CUPE("Cupê"),
    ESPORTIVO("Esportivo"),
    HATCH("Hatch"),
    PICAPE("Picape"),
    SEDAN("Sedan"),
    SUV("SUV"),
    VAN("Van");

    private final String nome;

    TipoCarro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
