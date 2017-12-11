import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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


    @Test
    public void staticRandomNumberTest2(){
        int min = 132;
        int max = 245;
        Assert.assertTrue("Static Random Number Test test failed!",
                (EcoSystem.randomNumberGenerator(min,max)>=min &&
                        EcoSystem.randomNumberGenerator(min,max)<=max));
    }


    @Test
    public void CheckIfFillableTest(){
        int min = 32;
        int max = 45;
        List<Coordinates2D> firstLocations = new ArrayList<>();

        // all points are not in vicinity of a given organism.
        firstLocations.add(new Coordinates2D(112,344));
        firstLocations.add(new Coordinates2D(393,400));

        EcoSystem ecs = new EcoSystem();
        ecs.setFirstGenOccupiedLocations(firstLocations);


        // shouldn't allow to accommodate, which is supposed to fail the condition.
        Assert.assertFalse("Check If Fillable Test failed!",
                 EcoSystem.checkIfFillable(min,max,10));
    }


    @Test
    public void CheckIfFillableTest2(){
        int min = 90;
        int max = 100;
        List<Coordinates2D> firstLocations = new ArrayList<>();

        // all points are in the vicinity of a given organism.
        firstLocations.add(new Coordinates2D(100,110));
        firstLocations.add(new Coordinates2D(80,90));
        firstLocations.add(new Coordinates2D(80,100));

        EcoSystem ecs = new EcoSystem();
        ecs.setFirstGenOccupiedLocations(firstLocations);


        // should allow to accommodate, which is supposed to pass the condition.
        Assert.assertTrue("Check If Fillable Test failed!",
                EcoSystem.checkIfFillable(min,max,10));
    }



}
