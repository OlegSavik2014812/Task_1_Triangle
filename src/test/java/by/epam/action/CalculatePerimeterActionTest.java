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
public class CalculatePerimeterActionTest {
    private TriangleCreator triangleCreator;

    @BeforeMethod
    public void setUp() throws CouldNotCreateShapeException {
        triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMETER);
    }

    @Test
    public void shouldCalculateTrianglePerimeterTest() throws Exception {
        CalculateAction calculatePerimeter = new CalculatePerimeterAction();
        String result = calculatePerimeter.calculate(triangleCreator.returnTriangles().get(0));
        assertEquals(result, Constants.PERIMETER_IS + 12);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void shouldNotCalculateTrianglePerimeterTest() throws Exception {
        CalculateAction calculatePerimeter = new CalculatePerimeterAction();
        triangleCreator.returnTriangles().clear();
        String result = calculatePerimeter.calculate(triangleCreator.returnTriangles().get(0));
        assertEquals(result, Constants.PERIMETER_IS + 6.0);
    }
}