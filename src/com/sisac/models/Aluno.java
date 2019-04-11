package com.sisac.models;

import java.time.LocalDate;

public class Aluno extends Pessoa{

    private int id;

    public int getId() {
        return id;
    }

    public Aluno(int id, LocalDate dataMatricula, LocalDate dataLimiteMatricula) {
        this.id = id;
        this.dataMatricula = dataMatricula;
        this.dataLimiteMatricula = dataLimiteMatricula;
    }

    public void setId(int id) {
        this.id = id;
    }

    private LocalDate dataMatricula;
    private LocalDate dataLimiteMatricula;

    public Aluno() {}

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public LocalDate getDataLimiteMatricula() {
        return dataLimiteMatricula;
    }

    public void setDataLimiteMatricula(LocalDate dataLimiteMatricula) {
        this.dataLimiteMatricula = dataLimiteMatricula;
    }
}
