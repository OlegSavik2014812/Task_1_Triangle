package by.epam.validation;

import by.epam.shape.model.Point;
import by.epam.shape.model.ShapeItem;

import java.util.List;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class ShapeValidator extends BaseValidator<ShapeItem> {
    @Override
    public boolean validate(ShapeItem shapeItem) {
        if (shapeItem == null) {
            return false;
        }

        List<Point> points = shapeItem.getPoints();

        if (points == null) {
            return false;
        }

        if (points.isEmpty()) {
            return false;
        }
        return validateNext(shapeItem);
    }
}