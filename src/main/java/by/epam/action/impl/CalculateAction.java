package by.epam.action.impl;

import by.epam.action.Action;
import by.epam.action.TriangleObserver;
import by.epam.shape.model.Point;

import java.util.List;

/**
 * Created by Oleg Savik on 11.10.2017.
 */

public abstract class CalculateAction implements Action{

    Double calculateDistance(Point point1, Point point2) {
        return Math.hypot(Math.abs(point1.getX() - point2.getX()), Math.abs(Math.abs(point1.getY() - point2.getY())));
    }

    Double calculateLength(double firstArg, double secondArg) {
        return Math.hypot(firstArg, secondArg);
    }

    Double calculateHalfPerimeter(List<Point> pointList) {
        return calculatePerimeter(pointList) / 2;
    }

    Double calculatePerimeter(List<Point> pointList) {
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


