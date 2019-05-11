package com.sisac.models;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class AlunoTest {
    Aluno a1 = new Aluno(1, LocalDate.now(), LocalDate.now(), "Azul");

    @Test
    public void printTitulo() {
        System.out.println(a1.printTitulo());
    }
}