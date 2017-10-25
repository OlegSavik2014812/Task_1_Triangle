package by.epam.action;

import by.epam.shape.model.Point;

import java.util.List;

/**
 * Created by Oleg Savik on 11.10.2017.
 */

public abstract class CalculateAction implements Action {

    public Double calculateDistance(Point point1, Point point2) {
        double distance = Math.hypot(Math.abs(point1.getX() - point2.getX()), Math.abs(Math.abs(point1.getY() - point2.getY())));
        return distance;
    }

    public Double calculateHalfPerimeter(List<Point> pointList) {
        return calculatePerimeter(pointList) / 2;
    }

    public Double calculatePerimeter(List<Point> pointList) {
        double perimeter = 0.0;

        for (int i = 0; i < pointList.size(); i++) {
            Point point1 = pointList.get(i);
            Point point2;
            if (i == pointList.size() - 1) {
                point2 = pointList.get(0);
            } else {
                point2 = pointList.get(i + 1);
            }
            perimeter += calculateDistance(point1, point2);
        }
        return perimeter;
    }
}
