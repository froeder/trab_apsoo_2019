/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.sisac.models;

/**
 *
 * @author carvalho
 */
public class Recibo {
    private Pagamento pagamento;

    public Recibo(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
    
}
