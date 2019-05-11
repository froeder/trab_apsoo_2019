package br.ufms.facom.sisac.models;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class AlunoTest {
    Aluno a1 = new Aluno(1, "Azul", LocalDate.now(), LocalDate.now(), 
    "Joao", "Rua 10", "CG", "MS", "23232323", 200);
    
    RelatorioFinanceiro rf = new RelatorioFinanceiro(a1);
    
    @Test
    public void printTitulo() {
        System.out.println(a1.printTitulo());
    }
    
}