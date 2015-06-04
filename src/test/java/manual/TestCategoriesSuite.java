package manual;

import manual.TestCategoriesSuite.TestesInstaveis;
import manual.TestCategoriesSuite.TestesJunit;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author rvsfara
 */
@RunWith(Categories.class)
@IncludeCategory(TestesJunit.class)
@ExcludeCategory(TestesInstaveis.class)
@SuiteClasses({
TestesJunit.class,  
TestManual.class
})
public class TestCategoriesSuite {
    public interface TestesJunit {}  
    public interface TestesNormais {}  
    public interface TestesComCargaDeBanco {}  
    public interface TestesInstaveis {}  
    public interface TestesIgnorados {}
    
}
