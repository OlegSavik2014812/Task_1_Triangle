package by.epam.action.impl;

import by.epam.constant.Constants;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.model.Point;
import by.epam.shape.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Oleg Savik on 06.10.2017.
 */
public class CheckOrthogonalTriangleAction extends CalculateAction {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public String calculate(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        double lengthBetweenX0andX1 = calculateLength(points.get(1).getX(), points.get(0).getX());
        double lengthBetweenX0andX2 = calculateLength(points.get(2).getX(), points.get(0).getX());
        double lengthBetweenX1andX2 = calculateLength(points.get(2).getX(), points.get(1).getX());
        double lengthBetweenY0andY1 = calculateLength(points.get(1).getY(), points.get(0).getY());
        double lengthBetweenY0andY2 = calculateLength(points.get(2).getY(), points.get(0).getY());
        double lengthBetweenY1andY2 = calculateLength(points.get(2).getY(), points.get(1).getY());
        double result1 = lengthBetweenX0andX1 * lengthBetweenX0andX2 + lengthBetweenY0andY1 * lengthBetweenY0andY2;
        double result2 = lengthBetweenX0andX1 * lengthBetweenX1andX2 + lengthBetweenY0andY1 * lengthBetweenY1andY2;
        double result3 = lengthBetweenX0andX2 * lengthBetweenX1andX2 + lengthBetweenY0andY2 * lengthBetweenY1andY2;
        if (result1 == 0) {
            LOGGER.info(Constants.ORTHOGONAL_IS + true);
            return Constants.ORTHOGONAL_IS + true;
        }
        if (result2 == 0) {
            LOGGER.info(Constants.ORTHOGONAL_IS + true);
            return Constants.ORTHOGONAL_IS + true;
        }
        if (result3 == 0) {
            LOGGER.info(Constants.ORTHOGONAL_IS + true);
            return Constants.ORTHOGONAL_IS + true;
        }
        LOGGER.info(Constants.ORTHOGONAL_IS + false);
        return Constants.ORTHOGONAL_IS + false;

    }

    @Override
    public void handleChanges(Triangle triangle) {
        calculate(triangle);
    }
}

