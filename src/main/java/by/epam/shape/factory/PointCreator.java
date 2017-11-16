package by.epam.shape.factory;

import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.model.Point;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public final class PointCreator {
    public List<Point> create(String line, String delimiter) throws CouldNotCreateShapeException {
        String[] arrayOfLines = line.split(delimiter);
        List<Point> pointList = new ArrayList<>();
        int i = 0;
        try {
            do {
                pointList.add(new Point(Double.parseDouble(arrayOfLines[i]), Double.parseDouble(arrayOfLines[i + 1])));
                i = i + 2;
            } while (i < arrayOfLines.length);
        } catch (NumberFormatException e) {
            throw new CouldNotCreateShapeException("Can't build " + line, e);
        }
        return pointList;
    }
}
