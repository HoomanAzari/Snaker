package assignment2;

public class Position {

    private int x_Coord;            //TODO how to check for your 0<x<...
    private int y_Coord;            //TODO same thing

    public Position(int x, int y) {
        if ((0 > x || x > (Math.pow(2, 31) - 1)) || (0 > y || y > (Math.pow(2,31) - 1))){
            throw new IllegalArgumentException("Value out of range.");         //TODO is this needed? throw exception if not within the range
        }
        this.x_Coord = x;
        this.y_Coord = y;
    }

    public Position(Position pos_obj) {
        this.x_Coord = pos_obj.x_Coord;
        this.y_Coord = pos_obj.y_Coord;
    }

    public void reset(int x, int y) {                       //setter method for X and Y
        if ((0 > x || x > (Math.pow(2, 31) - 1)) || (0 > y || y > (Math.pow(2,31) - 1))) {
            throw new IllegalArgumentException("Value out of range.");          //TODO is this needed, once again?
        }
        this.x_Coord = x;
        this.y_Coord = y;
    }

    public void reset(Position pos_obj) {                   //setter method for X and Y
        this.x_Coord = pos_obj.x_Coord;
        this.y_Coord = pos_obj.y_Coord;
    }

    public int getDistance(Position pos_1, Position pos_2) {                //TODO Ask only between two position objects?
        int x_dist = Math.abs(pos_1.x_Coord - pos_2.x_Coord);
        int y_dist = Math.abs(pos_1.y_Coord - pos_2.y_Coord);
        return x_dist + y_dist;
    }

    public int getX() {                 //getter method for X
        return this.x_Coord;
    }

    public int getY() {                 //getter method for Y
        return this.y_Coord;
    }

    public void moveWest() {            //decrements X by 1
        this.x_Coord -= 1;
    }

    public void moveEast() {           //increments X by 1
        this.x_Coord += 1;
    }

    public void moveNorth() {
        this.y_Coord -= 1;
    }

    public void moveSouth() {
        this.y_Coord += 1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position pos_Obj = (Position) obj;
            boolean x_Check = (this.x_Coord == pos_Obj.x_Coord);
            boolean y_Check = (this.y_Coord == pos_Obj.y_Coord);
            return (x_Check && y_Check);
        }
        return false;
    }
}
