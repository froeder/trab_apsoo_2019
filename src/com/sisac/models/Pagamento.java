package com.sisac.models;

import java.time.LocalDate;

public class Pagamento {

    private double valor;
    private LocalDate data;
    private String tipo;

    public Pagamento(){}

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
