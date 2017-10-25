package by.epam.action;

import by.epam.action.result.Result;
import by.epam.action.result.Results;
import by.epam.shape.model.ShapeItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class CalculatePerimeterAction extends CalculateAction {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public Result calculate(ShapeItem shapeItem) {
        double perimeter = calculatePerimeter(shapeItem.getPoints());
        LOGGER.info(Results.perimeterIs(perimeter));
        return Results.perimeterIs(perimeter);
    }
}
