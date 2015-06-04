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
        assertNull(pasta.getId());
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
        String expResult = "Diretório Raiz";
        String result = pasta.getPas_nome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPas_nome method, of class Pasta.
     */
    @Test
    public void testSetPas_nome() {
        String pas_nome = "Diretório Raiz";
        pasta.setPas_nome(pas_nome);
        assertEquals(pas_nome, pasta.getPas_nome());
    }

    /**
     * Test of getPas_caminho method, of class Pasta.
     */
    @Test
    public void testGetPas_caminho() {
        String expResult = "/";
        String result = pasta.getPas_caminho();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPas_caminho method, of class Pasta.
     */
    @Test
    public void testSetPas_caminho() {
        String pas_caminho = "/";
        pasta.setPas_caminho(pas_caminho);
        assertEquals(pas_caminho, pasta.getPas_caminho());
    }

    /**
     * Test of toString method, of class Pasta.
     */
    @Test
    public void testToString() {
        String expResult = pasta.getPas_caminho()+pasta.getPas_nome();
        String result = pasta.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Aqui a concatenação devia funcionar");
    }

    /**
     * Test of realizaOperacoes method, of class Pasta.
     */
    @Test
    public void testRealizaOperacoes() {
        String expResult = "Realizando Operações solicitadas para esse diretório /Diretório Raiz";
        String result = pasta.realizaOperacoes();
        assertEquals("Esta coisa vai falhar porque fiz uma gambiarra de concatenação, devo utlizar StringBuilder?", expResult, result);
    }
    
}
