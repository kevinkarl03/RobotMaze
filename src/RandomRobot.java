import java.util.ArrayList;
import java.util.Random;

public class RandomRobot {
    private Position pos;
    private Position prevPos;
    private final Maze maze;
    // Constructor
    public RandomRobot(Maze mazeInput){
        this.maze = mazeInput;
        this.pos = maze.getStart();
        this.prevPos = maze.getStart();
    }

    public void move(){
        ArrayList<Position> nextPosArr = new ArrayList<>();
        if(this.maze.isMovable(this.pos.getPositionToEast()) &&
                !pos.getPositionToEast().equal(prevPos)){
            nextPosArr.addLast(pos.getPositionToEast());
        }
        if(this.maze.isMovable(this.pos.getPositionToWest()) &&
                !pos.getPositionToWest().equal(prevPos)){
            nextPosArr.addLast(pos.getPositionToWest());
        }
        if(this.maze.isMovable(this.pos.getPositionToSouth()) &&
                !pos.getPositionToSouth().equal(prevPos)){
            nextPosArr.addLast(pos.getPositionToSouth());
        }
        if(this.maze.isMovable(this.pos.getPositionToNorth()) &&
                !pos.getPositionToNorth().equal(prevPos)){
            nextPosArr.addLast(pos.getPositionToNorth());
        }

        if(!nextPosArr.isEmpty()){
            Random random = new Random();
            int index = random.nextInt(nextPosArr.size());
            this.setPosition(nextPosArr.get(index));

        } else {
            this.setPosition(prevPos);
        }

    }

    private void setPosition(Position newPosition){
        this.prevPos = this.pos;
        this.pos = newPosition;
    }

    public Position getPosition(){
        return pos;
    }
    public boolean hasReachedGoal(){
        return this.maze.isGoal(pos);
    }
}
