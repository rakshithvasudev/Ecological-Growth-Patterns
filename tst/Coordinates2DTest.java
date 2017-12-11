import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rakshith on 12/11/2017.
 */
public class Coordinates2DTest {

    @Test
    public void constructorTest(){
        Coordinates2D cd = new Coordinates2D(12,34);

        Assert.assertEquals("Sorry Test failed",12,cd.getX());
    }

    @Test
    public void getXTest(){
        Coordinates2D cd = new Coordinates2D(35,450);

        Assert.assertEquals("Failed!",35,cd.getX());
    }

    @Test
    public void getYTest(){
        Coordinates2D cd = new Coordinates2D(35,450);

        Assert.assertEquals("Failed!",450,cd.getY());
    }


    @Test
    public void equalsTest(){
        Coordinates2D cd1 = new Coordinates2D(35,450);
        Coordinates2D cd2 = new Coordinates2D(35,450);

        Assert.assertTrue("Failed!",cd1.equals(cd2));
    }


    @Test
    public void hashCodeTest(){

        // Assert
        Coordinates2D cd1 = new Coordinates2D(35,450);

        
        int hashCode1 = cd1.hashCode();
        int hashCode2 = cd1.hashCode();

        // Evaluate
        Assert.assertTrue("Failed!",hashCode1==hashCode2);
    }

}
