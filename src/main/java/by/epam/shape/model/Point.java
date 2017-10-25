package by.epam.shape.model;

/**
 * Created by Oleg Savik on 06.10.2017.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + x);
        result = (int) (prime * result + y);
        return result;
    }

    @Override
    public String toString() {
        return "Point (x= " + x + "; y= " + y + ")";

    }
}

