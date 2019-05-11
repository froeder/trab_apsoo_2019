package br.ufms.facom.sisac.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class RelatorioFinanceiro {
    private double totalPago;
    private double totalMensalidades;
    private Aluno aluno;

    public RelatorioFinanceiro(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public double totalPago(){
        double total = 0;
        for (Recibo recibo :  this.getRecibosAluno()) {
            if(recibo.getPagamento().isPago()) {
                total += recibo.getPagamento().getAluno().getValorMensalidade();
            }
        }
        return total;
    }
    
    public double totalMensalidades() {
        int qtdMensalidades = (int) ChronoUnit.MONTHS.between(
                aluno.getDataMatricula().withDayOfMonth(1),
                aluno.getDataLimiteMatricula().withDayOfMonth(1));
        
       return qtdMensalidades * this.aluno.getPagamentos().size();

    }
     public double totalDebitoMensalidades() {
        int qtdMensalidades = (int) ChronoUnit.MONTHS.between(
                aluno.getDataMatricula().withDayOfMonth(1),
                aluno.getDataLimiteMatricula().withDayOfMonth(1));
        
       double quantRestanteDeMensalidades = qtdMensalidades - this.aluno.getPagamentos().size();
       return quantRestanteDeMensalidades * this.aluno.getValorMensalidade();

    }
    public ArrayList<Recibo> getRecibosAluno(){
        ArrayList<Recibo> recibos = new ArrayList<>();
        for (Pagamento pagamento : this.aluno.getPagamentos()) {
            recibos.add(new Recibo(pagamento));
        }
        return recibos;
    }

    public String emitirRelatorioCompleto() {
        double debito = totalPago - totalMensalidades;
        return String.format(
                "Total Pago: %.2f" +
                "Total de Mensalidades: %.2f" +
                "Débito: .2f",
                totalPago, totalMensalidades, debito);
    }

    public String emitirRelatorioParcial(LocalDate dataInicial, LocalDate dataFinal) {
        return "";
    }
}
