package logic;

public class Point {
    public int x;
    public int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point anotherPoint = (Point)obj;
            if (x == anotherPoint.x && y == anotherPoint.y)
                return true;
        }
        return false;
    }
}
