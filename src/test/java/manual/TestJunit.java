package manual;

import manual.TestCategoriesSuite.TestesJunit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.experimental.categories.Category;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author rvsfara
 */
public class TestJunit {

    @Category(TestesJunit.class)
    @Test
    public void testAdd() {
        String str = "Junit esta Funcionando";
        assertEquals("Junit esta Funcionando", str);
    }
    public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestJunit.class, TestManual.class);
      
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result.wasSuccessful());
   }
}
