import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Maze {
    private List<List<Character>> maze;
    private int rows;
    private int cols;


    // Constructor
    /*
    * Gör så här:
    * 1. Läs in alla olika lines till olika array lists
    * 2. Sätt in dessa arraylists i en arraylist
    * */
    public Maze(Scanner scanner) {

        maze = new ArrayList<List<Character>>();

        this.cols = 0;
        this.rows = 0;
        while(scanner.hasNextLine()){
            ArrayList<Character> line = new ArrayList<>();
            String buffer = scanner.nextLine();
            if(buffer.length() > this.cols){
                this.cols = buffer.length();
            }
            this.rows++;

            for(int i = 0 ; i < buffer.length() ; i++){
                line.addLast(buffer.charAt(i));
            }
            maze.addLast(line);

        }
        System.out.println("Cols: " + this.cols + " Rows: " + this.rows);
    }

    public int getNumColumns(){
        return this.cols;
    }
    public int getNumRows(){
        return rows;
    }

    public void printMaze(){

        for(int i = 0 ; i < this.rows ; i++){

            List<Character> list = maze.get(i);

            for(int j = 0 ; j < this.cols ; j++){
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }

    public Position getStart() {
        for (int i = 0; i < this.rows; i++) {
            List<Character> list = maze.get(i);
            for (int j = 0; j < this.cols; j++) {
                if(list.get(j)=='S'){
                    return new Position(i,j);
                }
            }
        }
        return new Position(-1,-1);
    }
    public boolean isGoal(Position pos){
        try{
            if(maze.get(pos.getY()).get(pos.getX()) == 'G'){
                return true;
            }
        } catch (IndexOutOfBoundsException index){
            System.err.println("Index out of bound");
            return false;
        }

        return false;
    }
    public boolean isMovable(Position pos){
        int x = pos.getX();
        int y = pos.getY();
        if(x >= 0 && y >= 0){
            if(x < this.cols && y < this.rows){
                if(maze.get(y).get(x) != '*'){
                    return true;
                }
            }
        }
        return false;
    }

}
