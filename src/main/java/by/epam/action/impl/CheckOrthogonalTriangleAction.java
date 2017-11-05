package by.epam.action.impl;


import by.epam.constant.Constants;
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
        double a = calculateDistance(points.get(0), points.get(1));
        double b = calculateDistance(points.get(1), points.get(2));
        double c = calculateDistance(points.get(0), points.get(2));
        if (c > a && c > b) {
            if (Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow(b, 2))) {
                LOGGER.info(Constants.ORTHOGONAL_IS + true);
                return Constants.ORTHOGONAL_IS + true;
            }
        } else if (a > c && a > b) {
            if (Math.pow(a, 2) == (Math.pow(c, 2) + Math.pow(b, 2))) {
                LOGGER.info(Constants.ORTHOGONAL_IS + true);
                return Constants.ORTHOGONAL_IS + true;
            }
        } else if (b > a && b > c) {
            if (Math.pow(b, 2) == (Math.pow(c, 2) + Math.pow(a, 2))) {
                LOGGER.info(Constants.ORTHOGONAL_IS + true);
                return Constants.ORTHOGONAL_IS + true;
            }
        }
        LOGGER.info(Constants.ORTHOGONAL_IS + false);
        return Constants.ORTHOGONAL_IS + false;
    }
}

