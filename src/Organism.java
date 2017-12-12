import java.awt.*;
import java.io.Serializable;

/**
 * This class is responsible to representing organisms,
 * supports hashcode, equals and serialization.
 */
public class Organism implements Serializable{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public static final int ORGANISM_SIZE_PX = 4;
    private static DrawingPanel drawingPanel = new DrawingPanel(WIDTH, HEIGHT);
    private static Graphics graphics = drawingPanel.getGraphics();
    private int x, y;

    public Organism(int x, int y){
        this.x = x;
        this.y = y;
        graphics.fillRect(x, y, ORGANISM_SIZE_PX, ORGANISM_SIZE_PX);
    }

    @Override
    public String toString() {
        return "Organism plotted at (" + x
                + ", " + y +")";
    }


    /**
     * Performs state comparison on the co-ordinates.
     * @param o object to be checked for
     * @return true only if the objects are equal state wise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organism organism = (Organism) o;
        return x == organism.x && y == organism.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
