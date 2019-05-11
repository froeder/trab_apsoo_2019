package com.sisac.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno extends Pessoa{

    private int id;
    private String faixa;
    public Aluno() {

    }

    public Aluno(int id, LocalDate dataMatricula, LocalDate dataLimiteMatricula, String faixa) {
        this.id = id;
        this.dataMatricula = dataMatricula;
        this.dataLimiteMatricula = dataLimiteMatricula;
        this.faixa = faixa;
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

    public void promoverAluno(String novaFaixa) {
        this.faixa = novaFaixa;
    }

    public void enviarConviteExame(LocalDate dataExame) {
        /* Ver como enviar email em Java */
    }

    public String printTitulo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dataFormatada = dataMatricula.format(formatter);

        return String.format("" +
                "Aluno: %s\n" +
                "Data de Matrícula: %s\n" +
                "Faixa: %s\n",
                this.getNome(), dataFormatada, this.faixa);
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
