package shouty;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public int distanceFrom(Coordinate other) {

        int xDistance = Math.abs(x - other.x);
        int yDistance = Math.abs(y - other.y);
        return Double.valueOf(Math.sqrt((xDistance*xDistance) + (yDistance*yDistance))).intValue();
    }
}
