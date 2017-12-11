import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rakshith on 12/11/2017.
 */
public class EcoSystemTest {

    @Test
    public void constructorTest(){
        EcoSystem ecs = new EcoSystem();
        Assert.assertTrue("Constructor test failed!",ecs.getClass()==EcoSystem.class);
    }


    @Test
    public void staticRandomNumberTest(){
        int min = 32;
        int max = 45;
        Assert.assertTrue("Static Random Number Test test failed!",
                (EcoSystem.randomNumberGenerator(min,max)>=min &&
                        EcoSystem.randomNumberGenerator(min,max)<=max));
    }
}
