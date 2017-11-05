package by.epam.action.impl;

import by.epam.constant.Constants;
import by.epam.shape.model.Point;
import by.epam.shape.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.util.Observable;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class CalculateAreaAction extends CalculateAction {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public String calculate(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        LOGGER.info(triangle.getPoints().toString());
        double halfPerimeter = calculateHalfPerimeter(points);
        double a = calculateDistance(points.get(0), points.get(1));
        double b = calculateDistance(points.get(1), points.get(2));
        double c = calculateDistance(points.get(0), points.get(2));
        double area = Math.pow(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c), 0.5);
        LOGGER.info(Constants.AREA_IS + area);
        return Constants.AREA_IS + area;
    }

    @Override
    public void handleEvent(Triangle triangle) {
        calculate(triangle);
    }
}
