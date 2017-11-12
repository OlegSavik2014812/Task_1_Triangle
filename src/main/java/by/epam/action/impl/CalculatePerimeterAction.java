package by.epam.action.impl;

import by.epam.constant.Constants;
import by.epam.shape.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class CalculatePerimeterAction extends CalculateAction {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public String calculate(Triangle triangle) {
        double perimeter = calculatePerimeter(triangle.getPoints());
        LOGGER.info(Constants.PERIMETER_IS + perimeter);
        return Constants.PERIMETER_IS + perimeter;
    }
}
