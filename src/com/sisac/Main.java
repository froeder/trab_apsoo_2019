package com.sisac;


import com.sisac.tests.daotests.AlunoDAOTest;
import com.sisac.tests.daotests.PagamentoDAOTest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        AlunoDAOTest.test();
        PagamentoDAOTest.test();
    }
}
