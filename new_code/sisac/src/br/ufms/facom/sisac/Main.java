package br.ufms.facom.sisac;

import br.ufms.facom.sisac.dao.AlunoDAO;
import br.ufms.facom.sisac.dao.PagamentoDAO;
import br.ufms.facom.sisac.models.Aluno;
import br.ufms.facom.sisac.models.RelatorioFinanceiro;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AlunoDAO alunoDao = new AlunoDAO();
        PagamentoDAO pagamentoDao = new PagamentoDAO();
        
        Aluno a1 = new Aluno();
        
        a1.setNome("João");
        a1.setEndereco("Rua X, 200 - Campo Grande/ MS");
        a1.setDataMatricula(LocalDate.now());
        a1.setDataLimiteMatricula(LocalDate.now());
        
        alunoDao.addAluno(a1);
    }      
}