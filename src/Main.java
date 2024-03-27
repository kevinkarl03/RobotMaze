import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* Init maze: */
        File mazeFile = new File(args[0]);



        /* NOTE: Need to have correct size of rows and cols for specified input */
        try{
            Scanner scanner = new Scanner(mazeFile);
            Maze maze = new Maze(scanner);
            maze.printMaze();



        } catch (FileNotFoundException exception){
            System.err.println("File not found");
        }
        catch (NullPointerException nullPointerException){
            System.err.println("Null pointer");
        }


        /* Init position in maze; */
        Position position = new Position(5,0);
        Position position1 = new Position(5, 0);
//        System.out.println("Equal: " + position.equal(position1));
//        System.out.println("Hashcode: " + position1.hashCode());
//        System.out.println("Hashcode: " + position.hashCode());


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