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
 * Created by Oleg Savik on 12.10.2017.
 */
public class CalculatePerimeterActionTest {
    private TriangleCreator triangleCreator;
    private String file = "./inputdata/inputdata.txt";
    private final static String delimiter = "[\\s]";

    @BeforeMethod
    public void setUp() throws CouldNotCreateShapeException {
        triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(file), delimiter);
    }

    @Test
    public void shouldCalculateTrianglePerimeterTest() throws Exception {
        //given
        CalculateAction calculatePerimeter = new CalculatePerimeterAction();
        //when
        Result result = calculatePerimeter.calculate(triangleCreator.getTriangles().get(0));
        //then
        assertEquals(result, Results.perimeterIs(12));
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void shouldNotCalculateTrianglePerimeterTest() throws Exception {
        //given
        CalculateAction calculatePerimeter = new CalculatePerimeterAction();
        //when
        triangleCreator.getTriangles().clear();
        Result result = calculatePerimeter.calculate(triangleCreator.getTriangles().get(0));
        //then
        assertEquals(result, Results.perimeterIs(0));
    }
}