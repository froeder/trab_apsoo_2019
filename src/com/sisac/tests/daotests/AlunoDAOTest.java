package com.sisac.tests.daotests;


import com.sisac.dao.AlunoDAO;
import com.sisac.models.Aluno;

public class AlunoDAOTest {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno();
        AlunoDAO dao = new AlunoDAO();

        aluno1.setNome("Maria");
        aluno1.setCidade("Birigui");
        aluno1.setEndereco("Rua 13");
        aluno1.setEstado("SP");
        aluno1.setTelefone("1199999999");

        dao.addAluno(aluno1);
    }

}
