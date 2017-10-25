package by.epam.action;

import by.epam.action.result.Result;
import by.epam.action.result.Results;
import by.epam.shape.model.Point;
import by.epam.shape.model.ShapeItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Oleg Savik on 06.10.2017.
 */
public class CheckOrthogonalTriangleAction extends CalculateAction {
    private final static Logger LOGGER = LogManager.getLogger();
    @Override
    public Result calculate(ShapeItem shapeItem) {
        List<Point> points = shapeItem.getPoints();
        double a = calculateDistance(points.get(0), points.get(1));
        double b = calculateDistance(points.get(1), points.get(2));
        double c = calculateDistance(points.get(0), points.get(2));
        if (c > a && c > b) {
            if (Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow(b, 2))) {
                LOGGER.info(Results.orthogonalIs(true));
                return Results.orthogonalIs(true);
            }
        } else if (a > c && a > b) {
            if (Math.pow(a, 2) == (Math.pow(c, 2) + Math.pow(b, 2))) {
                LOGGER.info(Results.orthogonalIs(true));
                return Results.orthogonalIs(true);
            }
        } else if (b > a && b > c) {
            if (Math.pow(b, 2) == (Math.pow(c, 2) + Math.pow(a, 2))) {
                LOGGER.info(Results.orthogonalIs(true));
                return Results.orthogonalIs(true);
            }
        }
        LOGGER.info(Results.orthogonalIs(false));
        return Results.orthogonalIs(false);
    }
}

