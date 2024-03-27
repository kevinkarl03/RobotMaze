import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Program is working properly if the robot is not able to "walk" outside the maze.
 * The walls need to contain the maze.
 */
public class Main {
    public static void main(String[] args) {


        /* Init maze: */
        File mazeFile = new File(args[0]);

        /* NOTE: Need to have correct size of rows and cols for specified input */
        try{
            Scanner scanner = new Scanner(mazeFile);
            Maze maze = new Maze(scanner);

            /* Traversal: */
            RandomRobot robot = new RandomRobot(maze);
            System.out.println("Start position: " + robot.getPosition());
            while (!robot.hasReachedGoal()){
                robot.move();
                if(robot.hasReachedGoal()){
                    System.out.println("Reached end at: " + robot.getPosition());
                } else {
                    System.out.println(robot.getPosition());
                }


            }

        } catch (FileNotFoundException exception){
            System.err.println("File not found");
        }
        catch (NullPointerException nullPointerException){
            System.err.println("Null pointer");
        }

    }

}