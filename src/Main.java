import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            // TEST FOR GIT ON LAPTOP
        /* NOTE: Program needs a correct file given as input maze */

        /* Init maze: */
        File mazeFile = new File(args[0]);
        int rows = getRowsFromFile(mazeFile);
        int cols = getColsFromFile(mazeFile);
        //System.out.println("Rows: " + rows + "\nCols: " + cols);

        /* NOTE: Need to have correct size of rows and cols for specified input */
        try{
            Scanner scanner = new Scanner(mazeFile);
            Maze maze = new Maze(scanner);
            maze.printMaze();
        } catch (FileNotFoundException exception){

        }




        /* Init position in maze; */
        Position position = new Position();
        //System.out.println("Pos x: " + position.x + "\nPos y: " + position.y);
    }

    private static int getColsFromFile(File mazeFile) {
        try {
            Scanner input = new Scanner(mazeFile);

            if (input.hasNextLine()) {
                String line = input.nextLine();
                input.close(); // Close the Scanner after reading
                return line.length();
            } else {
                System.out.println("Maze file was empty!");
                input.close(); // Close the Scanner in case of an empty file
                return -1;
            }
        } catch (Exception exception) {
            System.out.println("File not found: " + mazeFile.getPath());
            return -1; // Indicates file not found
        }
    }

    private static int getRowsFromFile(File mazeFile) {
        try {
            int count = 0;
            Scanner input = new Scanner(mazeFile);
            while (input.hasNextLine()) {
                String dummy = input.nextLine();
                count++;
            }
            return count;
        } catch (Exception exception) {
            System.out.println("File not found: " + mazeFile.getPath());
            return -1;
        }
    }


}