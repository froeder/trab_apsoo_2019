package com.sisac.models;

import java.time.LocalDate;

public class Aluno extends Pessoa{

    private int id;

    public Aluno() {

    }

    public Aluno(int id, LocalDate dataMatricula, LocalDate dataLimiteMatricula) {
        this.id = id;
        this.dataMatricula = dataMatricula;
        this.dataLimiteMatricula = dataLimiteMatricula;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private LocalDate dataMatricula;

    private LocalDate dataLimiteMatricula;

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

    @Override
    public String toString() {
        return "Aluno{" +
                ", id='" + id + '\'' +
                ", nome='" + this.getNome() + '\'' +
                ", endereco='" + this.getEndereco() + '\'' +
                ", cidade='" + this.getCidade() + '\'' +
                ", estado='" + this.getEstado() + '\'' +
                ", telefone='" + this.getTelefone() + '\'' +
                ", dataMatricula='" + dataMatricula + '\'' +
                ", dataLimiteMatricula='" + dataLimiteMatricula + '\'' +
                '}';
    }
}
