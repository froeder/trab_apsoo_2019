package br.ufms.facom.sisac.models;

import java.time.LocalDate;

public class Pagamento {
    private int id;
    private LocalDate data;
    private String tipo;
    private Aluno aluno;
    private boolean pago;
    
    public Pagamento(Aluno aluno) {
        this.aluno = aluno;
    }

    public Pagamento(int id, LocalDate data,
            String tipo, Aluno aluno) {
        this.id = id;
        this.data = data;
        this.tipo = tipo;
        this.aluno = aluno;
        this.pago = false;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    public Recibo emitirRecibo(){
        Recibo recibo = new Recibo(this);
        return recibo;
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
                ", valor=" + this.aluno.getValorMensalidade() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
