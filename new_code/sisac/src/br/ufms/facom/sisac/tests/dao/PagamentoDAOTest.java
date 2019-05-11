package br.ufms.facom.sisac.tests.dao;


import br.ufms.facom.sisac.dao.PagamentoDAO;
import br.ufms.facom.sisac.models.Aluno;
import br.ufms.facom.sisac.models.Pagamento;

import java.time.LocalDate;
import java.util.ArrayList;

public class PagamentoDAOTest {
    public static void test() {
      Aluno a1 = new Aluno(1, "Azul", LocalDate.now(), LocalDate.now(), 
    "Joao", "Rua 10", "CG", "MS", "23232323", 200);

        Pagamento p1 = new Pagamento(a1);
        Pagamento p2 = new Pagamento(a1);
        PagamentoDAO dao = new PagamentoDAO();

        p1.setData(LocalDate.of(2013, 04, 12));
        p1.setTipo("CARTAO_DE_CRETIDO");

        p2.setData(LocalDate.of(2013, 04, 12));
        p2.setTipo("DINHEIRO");


        dao.addPagamento(p1);
        dao.addPagamento(p2);

        dao.removePagamento(2);
        dao.updatePagamento(p2);

        ArrayList<Pagamento> Pagamentos = dao.fetchPagamentos(a1);
        for(Pagamento Pagamento: Pagamentos){
            System.out.println("Pagamento: " + Pagamento.toString());
        }
    }

}
