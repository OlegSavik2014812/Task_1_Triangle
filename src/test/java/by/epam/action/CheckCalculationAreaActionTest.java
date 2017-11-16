package by.epam.action;

import by.epam.action.impl.CalculateAction;
import by.epam.action.impl.CalculateAreaAction;
import by.epam.constant.Constants;
import by.epam.constant.RegExForTriangle;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.util.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Oleg Savik on 11.10.2017.
 */
public class CheckCalculationAreaActionTest {
    private TriangleCreator triangleCreator;

    @BeforeMethod
    public void setUp() throws CouldNotCreateShapeException {
        triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMITER);
    }

    @Test
    public void shouldCalculateTriangleAreaTest() {
        CalculateAction calculateAction = new CalculateAreaAction();
        String result = calculateAction.calculate(triangleCreator.returnTriangles().get(0));
        assertEquals(result, Constants.AREA_IS + 330.0);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void shouldNotCalculateTriangleAreaTest() {
        CalculateAction calculateAction = new CalculateAreaAction();
        triangleCreator.returnTriangles().clear();
        String result = calculateAction.calculate(triangleCreator.returnTriangles().get(0));
        assertEquals(result, Constants.AREA_IS + 6.0);
    }
}