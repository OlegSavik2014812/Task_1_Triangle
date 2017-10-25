package by.epam.action;

import by.epam.action.result.Result;
import by.epam.shape.model.ShapeItem;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public interface Action {
    Result calculate(ShapeItem shapeItem);
}
