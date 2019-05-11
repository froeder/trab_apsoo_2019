package br.ufms.facom.sisac.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Aluno extends Pessoa{

    private int id;
    private String faixa;
    private ArrayList<Pagamento> pagamentos;
    private double valorMensalidade;
    
    public Aluno() {
        this.pagamentos = new ArrayList<>();
    }

    public Aluno(int id, String faixa, LocalDate dataMatricula,
            LocalDate dataLimiteMatricula, String nome, String endereco,
            String cidade, String estado, String telefone, float valorMensalidade) {
        
        super(nome, endereco, cidade, estado, telefone);
        this.id = id;
        this.faixa = faixa;
        this.dataMatricula = dataMatricula;
        this.dataLimiteMatricula = dataLimiteMatricula;
        this.pagamentos = new ArrayList<>();
        
        
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
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
