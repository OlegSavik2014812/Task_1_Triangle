package by.epam.action;

import by.epam.action.result.Result;
import by.epam.action.result.Results;
import by.epam.shape.model.Point;
import by.epam.shape.model.ShapeItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class CalculateAreaAction extends CalculateAction {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public Result calculate(ShapeItem shapeItem) {
        List<Point> points = shapeItem.getPoints();
        LOGGER.info(shapeItem.getPoints().toString());
        double halfPerimeter = calculateHalfPerimeter(points);
        double a = calculateDistance(points.get(0), points.get(1));
        double b = calculateDistance(points.get(1), points.get(2));
        double c = calculateDistance(points.get(0), points.get(2));
        double area = Math.pow(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c), 0.5);
        LOGGER.info(Results.areaIs(area));
        return Results.areaIs(area);
    }
}
