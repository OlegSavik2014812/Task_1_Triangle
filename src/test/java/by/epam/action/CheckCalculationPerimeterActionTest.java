package by.epam.action;

import by.epam.action.impl.CalculateAction;
import by.epam.action.impl.CalculatePerimeterAction;
import by.epam.constant.Constants;
import by.epam.constant.RegExForTriangle;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.util.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Oleg Savik on 12.10.2017.
 */
public class CheckCalculationPerimeterActionTest {
    private TriangleCreator triangleCreator;

    @BeforeMethod
    public void setUp() throws CouldNotCreateShapeException {
        triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMITER);
    }

    @Test
    public void shouldCalculateTrianglePerimeterTest() {
        CalculateAction calculateAction = new CalculatePerimeterAction();
        String result = calculateAction.calculate(triangleCreator.returnTriangles().get(0));
        assertEquals(result, Constants.PERIMETER_IS + 132.0);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void shouldNotCalculateTrianglePerimeterTest() {
        CalculateAction calculateAction = new CalculatePerimeterAction();
        triangleCreator.returnTriangles().clear();
        String result = calculateAction.calculate(triangleCreator.returnTriangles().get(0));
        assertEquals(result, Constants.PERIMETER_IS + 6.0);
    }
}