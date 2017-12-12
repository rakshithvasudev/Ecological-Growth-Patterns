import java.io.Serializable;

/**
 *  A class that tracks the 2D co-ordinate for organisms.
 *
 *
 */
public class Coordinates2D implements Serializable {
    private int x;
    private int y;


    public Coordinates2D(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()){
            Coordinates2D obj = (Coordinates2D)o;
            return x == obj.x && y == obj.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
