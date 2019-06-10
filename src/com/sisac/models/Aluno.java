package com.sisac.models;


import java.time.format.DateTimeFormatter;

public class Aluno extends Pessoa{

    private int id;
    private Faixa faixa;
    private Matricula matricula;


    public Aluno() {

    }

    public Aluno(int id) {
        this.id = id;

    }

    public void promoverAluno(int faixa) {

    }

    public void trancarMatricula() {
        matricula.trancar();
    }

    public String getFaixa() {
        return faixa.
    }
    public void destrancarMatricula() {
        matricula.destrancar();
    }

    public String printTitulo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dataFormatada = matricula.getDataInicial().format(formatter);

        return String.format("" +
                "Aluno: %s\n" +
                "Data de Matrícula: %s\n" +
                "Faixa: %s\n",
                this.getNome(), dataFormatada, faixa.getGraduacao());
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Faixa getFaixa() {
        return faixa;
    }

    public Matricula getMatricula() {
        return matricula;
    }
}
