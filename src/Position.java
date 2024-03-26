public class Position {
    int x, y; // Position coordinates

    public Position(){
        this(0,0);
    }
    public Position(int a, int b){
        x = a;
        y = b;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public Position getPositionToSouth(){
        return new Position(this.x, this.y + 1);
    }
    public Position getPositionToNorth(){
        return  new Position(this.x, this.y - 1);
    }
    public Position getPositionToWest(){
        return new Position(this.x - 1, this.y);
    }
    public Position getPositionToEast(){
        return new Position(this.x + 1, this.y);
    }

    public boolean equal(Object o){
        return this.toString().equals(o.toString());
    }
    public int hashCode(){
        return this.toString().hashCode();
    }

/* ---- Helper methods ---- */

    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }


    public void printPos(){
        System.out.println("Pos: (" + getX() + ", " + getY() + ")");
    }
}
