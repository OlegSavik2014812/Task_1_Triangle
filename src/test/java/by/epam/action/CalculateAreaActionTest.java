package by.epam.action;

import by.epam.action.result.Result;
import by.epam.action.result.Results;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.util.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Oleg Savik on 11.10.2017.
 */
public class CalculateAreaActionTest {
    private TriangleCreator triangleCreator;
    private String file = "./inputdata/inputdata.txt";
    private final static String delimiter = "[\\s]";

    @BeforeMethod
    public void setUp() throws CouldNotCreateShapeException {
        triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(file), delimiter);
    }

    @Test
    public void shouldCalculateTriangleAreaTest() throws Exception {
        //given
        CalculateAction calculateAction = new CalculateAreaAction();
        //when
        Result result = calculateAction.calculate(triangleCreator.getTriangles().get(0));
        //then
        assertEquals(result, Results.areaIs(6.0));
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void shouldNotCalculateTriangleTest() {
        CalculateAction calculateAction = new CalculateAreaAction();
        triangleCreator.getTriangles().clear();
        Result result = calculateAction.calculate(triangleCreator.getTriangles().get(0));
        assertEquals(result, Results.areaIs(0));
    }
}