package assignment2;

public class Region {
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    public Region(int minX, int minY, int maxX, int maxY) {             //TODO can be smaller than 0?
        this.xMin = minX;
        this.xMax = maxX;
        this.yMin = minY;
        this.yMax = maxY;
    }
    public boolean contains(Position pos) {
        boolean minXCheck = pos.getX() >= this.xMin;
        boolean maxXCheck = pos.getX() <= this.xMax;
        boolean minYCheck = pos.getY() >= this.yMin;
        boolean maxYCheck = pos.getY() <= this.yMax;
        return (minXCheck && maxXCheck && minYCheck && maxYCheck);
    }
}
