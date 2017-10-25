package by.epam.action;

import by.epam.action.result.Result;
import by.epam.action.result.Results;
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
    private String file = "./inputdata/inputdata.txt";
    private final static String delimiter = "[\\s]";

    @BeforeMethod
    public void setUp() throws Exception {
        triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(file), delimiter);
    }

    @Test
    public void shouldCheckOrthogonalTriangleTest() {
        //given
        CheckOrthogonalTriangleAction checkOrthogonalTriangleAction = new CheckOrthogonalTriangleAction();
        //when
        Result result = checkOrthogonalTriangleAction.calculate(triangleCreator.getTriangles().get(0));
        //then
        assertEquals(result, Results.orthogonalIs(true));
    }

    @Test
    public void shouldNotCheckOrthogonalTriangleTest() {
        //given
        CheckOrthogonalTriangleAction checkOrthogonalTriangleAction = new CheckOrthogonalTriangleAction();
        //when
        Result result = checkOrthogonalTriangleAction.calculate(triangleCreator.getTriangles().get(1));
        //then
        assertEquals(result, Results.orthogonalIs(false));
    }
}