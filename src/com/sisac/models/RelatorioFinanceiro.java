package com.sisac.models;

import java.time.LocalDate;

public class RelatorioFinanceiro {
    private double totalPago;
    private double totalMensalidades;

    public String emitirRelatorioCompleto() {
        double debito = totalPago - totalMensalidades;
        return String.format(
                "Total Pago: %.2f" +
                "Total de Mensalidades: %.2f" +
                "Débito: .2f",
                totalPago, totalMensalidades, debito);
    }

    public String emitirRelatorioParcial(LocalDate dataInicial, LocalDate dataFinal) {

    }
}
