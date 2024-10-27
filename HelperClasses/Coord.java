package HelperClasses; 

/**
 * The Coord Class.
 * Creates coordinates which are used to faciliate drawing levels in the level builder 
 * 
 */
public class Coord {
    public final int x;
    public final int y;

    /**
     * The contructor for the coordinate class. 
     * @param x x position of the coordinate
     * @param y y postion of the coordinate
     */
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } 
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coord that = (Coord) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return 45 * x + 21 * y;
    }
}
