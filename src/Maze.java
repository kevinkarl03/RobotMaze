import java.io.File;
import java.util.Scanner;
public class Maze {
    /* Allocates new maze, default 1 by 1 */
    char[][] maze;
    int rows;
    int cols;

    // Basic constructor for a by b maze
    public Maze (int rows, int cols){
        this.maze = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;
        initMaze(rows, cols);
    }
    public int getNumColumns(){
        return this.cols;
    }
    public int getNumRows(){
        return rows;
    }
    private void initMaze(int rows, int cols){
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                maze[i][j] = 'x';
            }
        }
    }

    public void printMaze(){
        for(int i = 0 ; i < this.rows ; i++){
            for(int j = 0 ; j < this.cols ; j++){
                System.out.print(this.maze[i][j]);
            }
            System.out.println();
        }
    }

    public void inputMaze() {
        try {
            //System.out.print("Enter the file name with extension : ");
            //Scanner input = new Scanner(System.in);
            /*
            *  C:\\Users\\Admin\\IdeaProjects\\Robot-maze\\src\\maze.txt
            */

            Scanner input = new Scanner("C:\\Users\\Admin\\IdeaProjects\\Robot-maze\\src\\maze.txt");

            File file = new File(input.nextLine());

            input = new Scanner(file);

            int count = 0;
            while (input.hasNextLine()) {

                String line = input.nextLine();
                insertLine(line, count);
                count++;
            }
            input.close();



        } catch (Exception exception) {
            System.out.println("Failed! Caught error!");
        }
    }
    private void insertLine(String line, int count){
        for(int i = 0 ; i < line.length() ; i++){
            maze[count][i] = line.charAt(i);
        }
    }
}
