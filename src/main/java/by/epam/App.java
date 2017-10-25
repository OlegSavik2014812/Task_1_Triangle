package by.epam;

import by.epam.action.Action;
import by.epam.action.CalculateAreaAction;
import by.epam.action.CalculatePerimeterAction;
import by.epam.action.CheckOrthogonalTriangleAction;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.shape.model.Triangle;
import by.epam.util.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class App {

    private final static String delimiter = "[\\s]";
    private final static String DEMOFILE = "./inputdata/inputdata.txt";

    public static void main(String[] args) throws CouldNotCreateShapeException {

        Action calculateAreaAction = new CalculateAreaAction();
        Action calculatePerimeterAction = new CalculatePerimeterAction();
        CheckOrthogonalTriangleAction checkOrthogonalTriangleAction = new CheckOrthogonalTriangleAction();
        TriangleCreator triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(DEMOFILE), delimiter);
        for (Triangle triangle : triangleCreator.getTriangles()) {
            calculateAreaAction.calculate(triangle);
            calculatePerimeterAction.calculate(triangle);
            checkOrthogonalTriangleAction.calculate(triangle);
        }
    }
}



