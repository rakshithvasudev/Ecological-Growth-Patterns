import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rakshith on 12/11/2017.
 */
public class OrganismTest {

    @Test
    public void constructorTest() {

        Organism o = new Organism(34, 23);

        Assert.assertEquals("Constructor failed", 34, o.getX());

    }


    @Test
    public void getterXTest() {

        Organism o = new Organism(314, 23);

        Assert.assertEquals("getterXTest failed", 314, o.getX());

    }


    @Test
    public void getterYTest() {

        Organism o = new Organism(314, 213);

        Assert.assertEquals("getterYTest failed", 213, o.getY());

    }


    @Test
    public void EqualsTest() {

        Organism o1 = new Organism(314, 213);
        Organism o2 = new Organism(314, 213);


        Assert.assertTrue("EqualsTest failed", o1.equals(o2));

    }


    @Test
    public void hashcodeTest() {

        Organism o1 = new Organism(314, 213);
        Organism o2 = new Organism(314, 213);

        Assert.assertTrue("hashcodeTest failed", o1.hashCode() == o2.hashCode());
    }

    @Test
    public void toStringTest() {

        Organism o = new Organism(314, 213);

        Assert.assertTrue("toStringTest failed", o.toString().length() > 0);

    }
}
