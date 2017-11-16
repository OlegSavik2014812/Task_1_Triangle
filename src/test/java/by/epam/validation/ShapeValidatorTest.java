package by.epam.validation;

import by.epam.constant.Constants;
import by.epam.constant.RegExForTriangle;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.shape.model.Triangle;
import by.epam.util.FileUtils;
import by.epam.validation.impl.ShapeValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Oleg Savik on 12.10.2017.
 */
public class ShapeValidatorTest {
    private TriangleCreator triangleCreator;
    private ShapeValidator shapeValidator;
    private Triangle triangle;

    @BeforeMethod
    public void setUp() throws Exception {
        triangleCreator = new TriangleCreator();
        shapeValidator = new ShapeValidator();
    }

    @Test
    public void shouldValidateShapeTest() throws CouldNotCreateShapeException {
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMITER);
        triangle = triangleCreator.returnTriangles().get(0);
        assertEquals(shapeValidator.validate(triangle), true);
    }

    @Test
    public void shouldNotValidateShapeTest() throws CouldNotCreateShapeException {
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMITER);
        assertEquals(shapeValidator.validate(triangle), false);
    }
}