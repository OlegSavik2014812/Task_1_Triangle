package by.epam.action;

import by.epam.action.impl.CalculateAction;
import by.epam.action.impl.CheckOrthogonalTriangleAction;
import by.epam.constant.Constants;
import by.epam.constant.RegExForTriangle;
import by.epam.shape.factory.TriangleCreator;
import by.epam.util.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Oleg Savik on 12.10.2017.
 */
public class CheckOrthogonalTriangleActionTest {
    private TriangleCreator triangleCreator;

    @BeforeMethod
    public void setUp() throws Exception {
        triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMITER);
    }

    @Test
    public void shouldCheckOrthogonalTriangleTest() {
        CalculateAction calculateAction = new CheckOrthogonalTriangleAction();
        String result = calculateAction.calculate(triangleCreator.returnTriangles().get(0));
        assertEquals(result, Constants.ORTHOGONAL_IS + true);
    }

    @Test
    public void shouldNotCheckOrthogonalTriangleTest() {
        CalculateAction calculateAction = new CheckOrthogonalTriangleAction();
        String result = calculateAction.calculate(triangleCreator.returnTriangles().get(1));
        assertEquals(result, Constants.ORTHOGONAL_IS + false);
    }
}