package by.epam;
import by.epam.action.Action;
import by.epam.action.impl.CalculateAreaAction;
import by.epam.action.impl.CalculatePerimeterAction;
import by.epam.action.impl.CheckOrthogonalTriangleAction;
import by.epam.constant.Constants;
import by.epam.constant.RegExForTriangle;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.shape.model.Triangle;
import by.epam.util.FileUtils;
/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class App {
    public static void main(String[] args) throws CouldNotCreateShapeException {

        Action calculateAreaAction = new CalculateAreaAction();
        Action calculatePerimeterAction = new CalculatePerimeterAction();
        CheckOrthogonalTriangleAction checkOrthogonalTriangleAction = new CheckOrthogonalTriangleAction();
        TriangleCreator triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMETER);
        for (Triangle triangle : triangleCreator.returnTriangles()) {
            calculateAreaAction.calculate(triangle);
            calculatePerimeterAction.calculate(triangle);
            checkOrthogonalTriangleAction.calculate(triangle);
        }
    }
}



