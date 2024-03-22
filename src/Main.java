import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rows = getRowsFromFile();
        int cols = getColsFromFile();


        /* NOTE: Need to have correct size of rows and cols for specified input */
        Maze maze = new Maze(rows, cols);

        //maze.printMaze();

        maze.inputMaze();
        maze.printMaze();

        System.out.println("Cols: " + maze.getNumColumns());
        System.out.println("Rows: " + maze.getNumRows());
    }

    private static int getColsFromFile(){

        try{
            Scanner input = new Scanner("C:\\Users\\Admin\\IdeaProjects\\Robot-maze\\src\\maze.txt");

            File file = new File(input.nextLine());

            input = new Scanner(file);
            String line = input.nextLine();

            return line.length();

        } catch (Exception exception){
            System.out.println("Caught error in main!");
        }

        return -1;

    }

    private static int getRowsFromFile(){
        try{
            Scanner input = new Scanner("C:\\Users\\Admin\\IdeaProjects\\Robot-maze\\src\\maze.txt");

            File file = new File(input.nextLine());

            input = new Scanner(file);

            int count = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine(); // Dummy variable used to read lines in file
                count++;
            }
            return count;
        } catch (Exception exception){
            System.out.println("Caught error in main!");
        }
        return -1;
    }

}