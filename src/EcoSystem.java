import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class EcoSystem {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int ORGANISM_SIZE_PX = 15;
    private static DrawingPanel drawingPanel = new DrawingPanel(WIDTH, HEIGHT);
    private static Graphics graphics = drawingPanel.getGraphics();
    private static List<Coordinates2D> firstGenOccupiedLocations = new ArrayList<>();
    private static List<Coordinates2D> nextGenOccupiedLocations = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            generateFirstGenOrganisms(50);
            introduceDelay(1500);
            System.out.println("First Gen:" + firstGenOccupiedLocations);
            clearScreen();

            generateNextGenOrganisms(30);
            introduceDelay(500);
            System.out.println("Second gen: " + nextGenOccupiedLocations);
            clearFirstGenLocations();
            clearNextGenLocations();
        }
    }

    private static void clearNextGenLocations() {
        nextGenOccupiedLocations.clear();
    }

    private static void clearFirstGenLocations() {
        firstGenOccupiedLocations.clear();
    }

    private static void clearScreen() {
    drawingPanel.clear();
    }

    private static void introduceDelay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void generateNextGenOrganisms(int numberOfOrganisms) {
         generateOrganisms(numberOfOrganisms,2);
    }

    private static void generateOrganisms(int numberOfOrganisms, int generation) {
        for (int i = 0; i < numberOfOrganisms; i++) {
            int randX = randomNumberGenerator(0, WIDTH);
            int randY = randomNumberGenerator(0, HEIGHT);

            //
            if (generation ==1){
                graphics.fillRect(randX, randY, ORGANISM_SIZE_PX, ORGANISM_SIZE_PX);
                firstGenOccupiedLocations.add(new Coordinates2D(randX,randY));
            }else{

                graphics.fillRect(randX, randY, ORGANISM_SIZE_PX, ORGANISM_SIZE_PX);
                nextGenOccupiedLocations.add(new Coordinates2D(randX,randY));
            }
        }
    }

    public static int randomNumberGenerator(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void generateFirstGenOrganisms(int numberOfOrganisms) {
        generateOrganisms(numberOfOrganisms,1);
    }

    /**
     * Checks if there is an opportunity for a new organism to be grown
     * based on the rules that :
     * There was an organism at the location in the last generation and two of the eight
       neighboring locations also contained organisms;
     * Three of the eight neighboring locations contained organisms in the last generation.
     * @param x
     * @param y
     * @return
     */
    public static boolean checkIfFillable(int x, int y, int organismSize){
        int occupancyCounter = 0;

        // Iterate through all the points and look out for the neighbours
        for ( Coordinates2D e: firstGenOccupiedLocations) {

            //Diagonal left neighbour (x-p,y+p)
            if(new Coordinates2D(x-organismSize,y+organismSize).equals(e)){
                occupancyCounter++;
            }
            //top neighbour (x,y+p)
            else if(new Coordinates2D(x,y+organismSize).equals(e)){
                occupancyCounter++;
            }
            //top right neighbour (x+p,y+p)
            else if(new Coordinates2D(x+organismSize,y+organismSize).equals(e)){
                occupancyCounter++;
            }
            //right neighbour (x+p,y)
            else if(new Coordinates2D(x+organismSize,y).equals(e)){
                occupancyCounter++;
            }
            //bottom right neighbour (x+p,y)
            else if(new Coordinates2D(x+organismSize,y-organismSize).equals(e)){
                occupancyCounter++;
            }
            //bottom neighbour (x,y-p)
            else if(new Coordinates2D(x,y-organismSize).equals(e)){
                occupancyCounter++;
            }
            //bottom left neighbour (x-p,y-p)
            else if(new Coordinates2D(x-organismSize,y-organismSize).equals(e)){
                occupancyCounter++;
            }
            //left neighbour (x-p,y)
            else if(new Coordinates2D(x-organismSize,y).equals(e)){
                occupancyCounter++;
            }

        }

        return (occupancyCounter == 3)||(occupancyCounter ==2);
    }

}
