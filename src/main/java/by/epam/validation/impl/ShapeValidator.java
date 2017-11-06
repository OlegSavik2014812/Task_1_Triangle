package by.epam.validation.impl;

import by.epam.shape.model.Point;
import by.epam.shape.model.Triangle;

import java.util.List;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class ShapeValidator extends BaseValidator<Triangle> {
    @Override
    public boolean validate(Triangle triangle) {
        if (triangle == null) {
            return false;
        }

        List<Point> points = triangle.getPoints();

        if (points == null) {
            return false;
        }

        if (points.isEmpty()) {
            return false;
        }
        return validateNext(triangle);
    }
}