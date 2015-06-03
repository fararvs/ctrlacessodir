package manual;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 *
 * @author rvsfara
 */
public class TestJunit {
   @Test
   public void testAdd() {
      String str= "Junit esta Funcionando";
      assertEquals("Junit esta Funcionando",str);
   }
}
