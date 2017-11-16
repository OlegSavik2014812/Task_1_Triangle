package by.epam.validation.impl;

import by.epam.shape.model.Point;
import by.epam.shape.model.Triangle;

import java.util.List;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class TriangleValidator extends BaseValidator<Triangle> {
    @Override
    public boolean validate(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        if (points.size() != 3) {
            return false;
        }
        if ((points.get(1).getX() - points.get(0).getX()) * (points.get(2).getY() - points.get(0).getY()) - (points.get(1).getY() - points.get(0).getY()) * ((points.get(2).getX() - points.get(0).getX())) == 0) {
            return false;
        }
        return validateNext(triangle);
    }
}