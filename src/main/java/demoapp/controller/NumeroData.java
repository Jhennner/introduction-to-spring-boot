package demoapp.controller;

import javax.validation.constraints.Positive;

public class NumeroData {

    @Positive
    private int numero;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
