package manual;

import manual.TestCategoriesSuite.TestesJunit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 *
 * @author rvsfara
 */
public class TestManual {
    private static String mensagem;
    //@Before//Executa antes de cada Teste
    @BeforeClass//Executa Uma unica vez antes
    public static void inicializaLocal() {
        TestManual.mensagem = "inicializada";
        System.out.println("Inicializou a mensagem.");
    }
    @Category(TestesJunit.class)
    @Test
    public void testInicializadaLocal1() {
        Assert.assertEquals("A String deveria estar inicializada.", "inicializada",
                TestManual.mensagem);
    }
    // @Category({SmokeTests.class, TestesComCargaDeBanco.class})
   @Category(TestesJunit.class)
    @Test
    public void testInicializadaLocal2() {
        Assert.assertEquals("A String deveria estar inicializada.", "inicializada",
                TestManual.mensagem);
    }
   
    //@After//Executa depois de cada Teste
    @AfterClass//@BeforeClass//Executa Uma unica vez depois
    public static  void setaNull() {
        TestManual.mensagem = null;
        System.out.println("Setou nulo.");
    }
}
