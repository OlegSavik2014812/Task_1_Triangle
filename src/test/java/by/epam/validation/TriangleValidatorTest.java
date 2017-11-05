package by.epam.validation;

import by.epam.constant.Constants;
import by.epam.constant.RegExForTriangle;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.shape.model.Point;
import by.epam.shape.model.Triangle;
import by.epam.util.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Oleg Savik on 12.10.2017.
 */
public class TriangleValidatorTest {
    private TriangleCreator triangleCreator;
    private TriangleValidator triangleValidator;
    private Triangle triangle;
    private List<Point> pointList;

    @BeforeMethod
    public void setUp() throws Exception {
        pointList = new ArrayList<>();
        triangleCreator = new TriangleCreator();
        triangleValidator = new TriangleValidator();
        pointList.add(new Point(1, 2));
        pointList.add(new Point(2, 5));
    }

    @Test
    public void shouldValidateTriangleTest() throws CouldNotCreateShapeException {
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMETER);
        triangle = triangleCreator.returnTriangles().get(0);
        assertEquals(triangleValidator.validate(triangle), true);
    }

    @Test
    public void shouldNotValidateTriangleTest() throws CouldNotCreateShapeException {
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMETER);
        triangle = new Triangle(pointList);
        assertEquals(triangleValidator.validate(triangle), false);
    }
}