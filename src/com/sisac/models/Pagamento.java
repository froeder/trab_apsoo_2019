package com.sisac.models;

import java.time.LocalDate;

public class Pagamento {
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", valor=" + valor +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
