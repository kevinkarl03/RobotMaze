import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Maze {
    private List<List<Character>> maze;
    private int rows;
    private int cols;


    // Constructor
    public Maze(Scanner scanner) {

        try {
            boolean foundStart = false;
            boolean foundGoal = false;
            maze = new ArrayList<>();

            this.cols = 0;
            this.rows = 0;
            while (scanner.hasNextLine()) {
                ArrayList<Character> line = new ArrayList<>();
                String buffer = scanner.nextLine();
                if (buffer.length() > this.cols) {
                    this.cols = buffer.length();
                }
                this.rows++;

                for (int i = 0; i < buffer.length(); i++) {
                    line.addLast(buffer.charAt(i));
                    if(buffer.charAt(i) == 'S'){
                        foundStart = true;
                    }
                    if(buffer.charAt(i) == 'G'){
                        foundGoal = true;
                    }
                }
                maze.addLast(line);

            }
            if(!foundStart || !foundGoal){
                throw new Exception("Maze dont have all necessary elements");
            }

        } catch (Exception exception){
            System.err.println(exception);
            System.exit(-1); // MIGHT BE WRONG WAY TO EXIT
        }

    }

    public int getNumColumns(){
        return this.cols;
    }
    public int getNumRows(){
        return rows;
    }



    public Position getStart() {
        for (int i = 0; i < this.getNumRows(); i++) {
            List<Character> list = maze.get(i);
            for (int j = 0; j < this.getNumColumns(); j++) {
                if(list.get(j)== 'S'){
                    return new Position(j,i);
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
            if(x < this.getNumColumns() && y < this.getNumRows()){
                return maze.get(y).get(x) == ' ' || maze.get(y).get(x) == 'G';
            }
        }
        return false;
    }

    /* --- For debugging and understanding */
    public void printMaze(){

        for(int i = 0 ; i < this.getNumRows() ; i++){

            List<Character> list = maze.get(i);

            for(int j = 0 ; j < this.getNumColumns() ; j++){
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }

}
