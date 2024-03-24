import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Maze {
    char[][] maze;
    int rows;
    int cols;


    // Constructor
    public Maze(Scanner scanner) {
        Position values = getSizeInit(scanner);
        this.cols = values.getX();;
        this.rows = values.getY();
        System.out.println("ROWS: " + rows);
        System.out.println("COLS: " + cols);

        this.maze = new char[this.rows][this.cols];

        /* Does not go inside of loop (Think that scanner is at end of file) */
        try {
            int i = 0;
            while(scanner.hasNextLine()) {
                String buffer = scanner.nextLine();
                this.cols = buffer.length();
                System.out.println(buffer);
                this.insertLine(buffer, i);
                this.rows = i;
                i++;
            }
        } catch (Exception exception) {
            System.out.println("Failed! Caught error! (maze constructor)");
        }
    }


    private Position getSizeInit(Scanner scanner){
        try{
            Position pos = new Position();
            pos.x = 0;
            pos.y = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.length() >= pos.x){
                    pos.x = line.length();
                }
                pos.y++;
            }
            return pos;
        } catch (Exception exception){
            System.out.println("Error getRowsInit");
        }
        return new Position(-1, -1);
    }


    public int getNumColumns(){
        return this.cols;
    }
    public int getNumRows(){
        return rows;
    }

    public void printMaze(){
        for(int i = 0 ; i < this.rows ; i++){
            for(int j = 0 ; j < this.cols ; j++){
                System.out.print(this.maze[i][j]);
            }
            System.out.println();
        }
    }


    private void insertLine(String line, int count){
        for(int j = 0 ; j < line.length() ; j++){
            maze[count][j] = line.charAt(j);
        }
    }


}
