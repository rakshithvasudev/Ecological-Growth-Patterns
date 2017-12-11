import java.awt.*;

/**
 * Created by Rakshith on 12/11/2017.
 */
public class Main2 {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int ORGANISM_SIZE_PX = 4;
    private static DrawingPanel drawingPanel = new DrawingPanel(WIDTH, HEIGHT);
    private static Graphics graphics = drawingPanel.getGraphics();

    public static void main(String[] args) {

    generateFirstOrganisms(500);
    drawingPanel.setGridLines(true);
    drawingPanel.setPixel(66,78,125);
    }

    public static void generateFirstOrganisms(int numberOfOrganisms) {

    }

}
