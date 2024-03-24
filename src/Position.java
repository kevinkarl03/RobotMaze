public class Position {
    int x, y; // Position coordinates

    public Position(){
        x = 0;
        y = 0;
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

    /*
     * Equals, och hashcode functions later
     *
     *  */

}
