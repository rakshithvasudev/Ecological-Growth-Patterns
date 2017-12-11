import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Rakshith on 12/11/2017.
 * CSC 527 - Extra credit homework.
 */


/**
 * Compile all the test cases and generate a test suite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        // include all the test classes to be tested

        Coordinates2DTest.class,
        EcoSystemTest.class

})

public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
