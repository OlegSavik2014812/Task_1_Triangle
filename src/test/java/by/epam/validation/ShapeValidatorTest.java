package by.epam.validation;

import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.shape.model.ShapeItem;
import by.epam.util.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Oleg Savik on 12.10.2017.
 */
public class ShapeValidatorTest {
    private TriangleCreator triangleCreator;
    private ShapeValidator shapeValidator;
    private ShapeItem shapeItem;
    private String file = "./inputdata/inputdata.txt";
    private final static String delimiter = "[\\s]";

    @BeforeMethod
    public void setUp() throws Exception {
        triangleCreator = new TriangleCreator();
        shapeValidator = new ShapeValidator();

    }

    @Test
    public void shouldValidateShapeTest() throws CouldNotCreateShapeException {
        //given
        triangleCreator.createFromFile(FileUtils.openFile(file), delimiter);
        shapeItem = triangleCreator.getTriangles().get(0);
        //when

        //then
        assertEquals(shapeValidator.validate(shapeItem), true);

    }

    @Test
    public void shouldNotValidateShapeTest() throws CouldNotCreateShapeException {
        //given
        triangleCreator.createFromFile(FileUtils.openFile(file), delimiter);
        //when
        //then
        assertEquals(shapeValidator.validate(shapeItem), false);

    }
}