package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rvsfara
 */
public class PastaTest {
    private Pasta pasta;
    public PastaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pasta = new Pasta();
        //pasta.setId(Integer.toUnsignedLong(1));
        pasta.setPas_nome("Diretório Raiz");
        pasta.setPas_caminho("/");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Pasta.
     */
    @Test
    public void testGetId() {
        System.out.println("Testando Obter o Id, mas ele é gerado pelo banco");
        Long expResult = 1L;
        Long result = pasta.getId();
        assertEquals(expResult, result);
        fail("Este Teste Deve Falhar !.");
    }

    /**
     * Test of setId method, of class Pasta.
     */
    @Test
    public void testSetId() {
        System.out.println("Setando o Id");
        pasta.setId(1L);
        Long expResult = 1L;
        assertEquals(expResult, pasta.getId());
    }

    /**
     * Test of getPas_nome method, of class Pasta.
     */
    @Test
    public void testGetPas_nome() {
        System.out.println("getPas_nome");
        Pasta instance = new Pasta();
        String expResult = "";
        String result = instance.getPas_nome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPas_nome method, of class Pasta.
     */
    @Test
    public void testSetPas_nome() {
        System.out.println("setPas_nome");
        String pas_nome = "";
        Pasta instance = new Pasta();
        instance.setPas_nome(pas_nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPas_caminho method, of class Pasta.
     */
    @Test
    public void testGetPas_caminho() {
        System.out.println("getPas_caminho");
        Pasta instance = new Pasta();
        String expResult = "";
        String result = instance.getPas_caminho();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPas_caminho method, of class Pasta.
     */
    @Test
    public void testSetPas_caminho() {
        System.out.println("setPas_caminho");
        String pas_caminho = "";
        Pasta instance = new Pasta();
        instance.setPas_caminho(pas_caminho);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Pasta.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Pasta instance = new Pasta();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizaOperacoes method, of class Pasta.
     */
    @Test
    public void testRealizaOperacoes() {
        System.out.println("realizaOperacoes");
        Pasta instance = new Pasta();
        String expResult = "";
        String result = instance.realizaOperacoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
