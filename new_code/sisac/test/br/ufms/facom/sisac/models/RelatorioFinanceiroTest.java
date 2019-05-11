/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.sisac.models;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carvalho
 */
public class RelatorioFinanceiroTest {
    
    public RelatorioFinanceiroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of totalPago method, of class RelatorioFinanceiro.
     */
    @Test
    public void testTotalPago() {
        System.out.println("totalPago");
        RelatorioFinanceiro instance = null;
        double expResult = 0.0;
        double result = instance.totalPago();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalMensalidades method, of class RelatorioFinanceiro.
     */
    @Test
    public void testTotalMensalidades() {
        System.out.println("totalMensalidades");
        RelatorioFinanceiro instance = null;
        double expResult = 0.0;
        double result = instance.totalMensalidades();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecibosAluno method, of class RelatorioFinanceiro.
     */
    @Test
    public void testGetRecibosAluno() {
        System.out.println("getRecibosAluno");
        RelatorioFinanceiro instance = null;
        ArrayList<Recibo> expResult = null;
        ArrayList<Recibo> result = instance.getRecibosAluno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of emitirRelatorioCompleto method, of class RelatorioFinanceiro.
     */
    @Test
    public void testEmitirRelatorioCompleto() {
        System.out.println("emitirRelatorioCompleto");
        RelatorioFinanceiro instance = null;
        String expResult = "";
        String result = instance.emitirRelatorioCompleto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of emitirRelatorioParcial method, of class RelatorioFinanceiro.
     */
    @Test
    public void testEmitirRelatorioParcial() {
        System.out.println("emitirRelatorioParcial");
        LocalDate dataInicial = null;
        LocalDate dataFinal = null;
        RelatorioFinanceiro instance = null;
        String expResult = "";
        String result = instance.emitirRelatorioParcial(dataInicial, dataFinal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
