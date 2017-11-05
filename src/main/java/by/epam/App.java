package by.epam;

import by.epam.action.Action;
import by.epam.action.impl.CalculateAreaAction;
import by.epam.action.impl.CalculatePerimeterAction;
import by.epam.action.impl.CheckOrthogonalTriangleAction;
import by.epam.constant.Constants;
import by.epam.constant.RegExForTriangle;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.shape.model.Point;
import by.epam.shape.model.Triangle;
import by.epam.util.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class App {
    public static void main(String[] args) throws CouldNotCreateShapeException {

        List<Point> list = new ArrayList<>();
        list.add(new Point(2, 2));
        list.add(new Point(123, 1));
        list.add(new Point(521, 1234));
        TriangleCreator triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMETER);
        Triangle triangle=triangleCreator.returnTriangles().get(0);
        triangle.notifyObservers();
        /* Action calculateAreaAction = new CalculateAreaAction();
        Action calculatePerimeterAction = new CalculatePerimeterAction();
        CheckOrthogonalTriangleAction checkOrthogonalTriangleAction = new CheckOrthogonalTriangleAction();
        for (Triangle triangle : triangleCreator.returnTriangles()) {
            calculateAreaAction.calculate(triangle);
            calculatePerimeterAction.calculate(triangle);
            checkOrthogonalTriangleAction.calculate(triangle);
        }*/
    }
}



