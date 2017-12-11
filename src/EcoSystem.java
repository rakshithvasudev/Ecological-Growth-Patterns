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

    /**
     * Generate the organisms based on the rules continuously.
     * @param args
     */
    public static void main(String[] args) {
        // keep getting the simulation continuously.
        while (true) {
            generateFirstGenOrganisms(150);
            introduceDelay(500);
            System.out.println("First Gen:" + firstGenOccupiedLocations);


            generateNextGenOrganisms(100);
            introduceDelay(100);
            System.out.println("Second gen: " + nextGenOccupiedLocations);

            clearFirstGenLocations();
            clearNextGenLocations();
            clearScreen();
        }
    }

    /**
     * Clears the memory locations for the second generations and beyond.
     */
    private static void clearNextGenLocations() {
        nextGenOccupiedLocations.clear();
    }

    /**
     * Clears the memory locations for the first gen.
     */
    private static void clearFirstGenLocations() {
        firstGenOccupiedLocations.clear();
    }

    /**
     * Clears the screen
     */
    private static void clearScreen() {
    drawingPanel.clear();
    }

    /**
     * Delay the execution of the program by a specified time.
     * @param i time to delay.
     */
    private static void introduceDelay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate the second generations and beyond organisms
     * @param numberOfOrganisms number of organisms to be generated.
     */
    private static void generateNextGenOrganisms(int numberOfOrganisms) {
         generateOrganisms(numberOfOrganisms,2);
    }

    /**
     * Generates the organisms based on the generation and accounts for
     * neighborhood understanding and accommodation.
     *
     * @param numberOfOrganisms number of organisms that has to be used.
     * @param generation the generation that has to be considered for.
     */
    private static void generateOrganisms(int numberOfOrganisms, int generation) {
        for (int i = 0; i < numberOfOrganisms; i++) {
            int randX = randomNumberGenerator(0, WIDTH);
            int randY = randomNumberGenerator(0, HEIGHT);

            // if first generation then directly paint
            if (generation ==1){
                graphics.fillRect(randX, randY, ORGANISM_SIZE_PX, ORGANISM_SIZE_PX);
                firstGenOccupiedLocations.add(new Coordinates2D(randX,randY));
            }

            // check if fillable in the neighbour hood and then do the process of filling.
            else{
                if(checkIfFillable(randX,randY,ORGANISM_SIZE_PX)) {
                    graphics.fillRect(randX, randY, ORGANISM_SIZE_PX, ORGANISM_SIZE_PX);
                }
                // keep a track of new locations
                nextGenOccupiedLocations.add(new Coordinates2D(randX,randY));
            }
        }
    }

    /**
     * Generates a random int in the limit [min, max].
     * @param min least value that needs to be included during generation.
     * @param max max value that needs to be included during generation.
     * @return a random int
     */
    public static int randomNumberGenerator(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Generates the first gen organisms
     * @param numberOfOrganisms count of organisms that needs to be generated.
     */
    public static void generateFirstGenOrganisms(int numberOfOrganisms) {
        generateOrganisms(numberOfOrganisms,1);
    }

    /**
     * Checks if there is an opportunity for a new organism to be grown
     * based on the rules that :
     * There was an organism at the location in the last generation and two of the eight
       neighboring locations also contained organisms;
     * Three of the eight neighboring locations contained organisms in the last generation.
     * @param x x co-ordinate to check
     * @param y y co-ordinate to check
     * @return true if a new organism can be accommodated based on the rules.
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

    /**
     * Gets the locations
     * @return the filled first gen occupied spots.
     */
    public static List<Coordinates2D> getFirstGenOccupiedLocations() {
        return firstGenOccupiedLocations;
    }

    /**
     * Sets the Occupied locations. (Used for testing).
     * @param firstGenOccupiedLocations sets the value from the input.
     */
    public static void setFirstGenOccupiedLocations(List<Coordinates2D> firstGenOccupiedLocations) {
        EcoSystem.firstGenOccupiedLocations = firstGenOccupiedLocations;
    }
}
