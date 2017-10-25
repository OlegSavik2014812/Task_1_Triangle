package by.epam.validation;

import by.epam.shape.model.Point;
import by.epam.shape.model.ShapeItem;

import java.util.List;

/**
 * Created by Oleg Savik on 08.10.2017.
 */

public class TriangleValidator extends BaseValidator<ShapeItem> {

    @Override
    public boolean validate(ShapeItem shapeItem) {
        List<Point> points = shapeItem.getPoints();
        if (points.size() != 3) {
            return false;
        }

        if (((points.get(2).getX() - points.get(0).getX()) / (points.get(1).getX() - points.get(0).getX())) == ((points.get(2).getY() - points.get(0).getY()) / (points.get(1).getY() - points.get(0).getY()))) {
            return false;
        }

        return validateNext(shapeItem);
    }
}
