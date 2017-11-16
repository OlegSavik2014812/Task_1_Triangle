package by.epam.compare_triangles;

import by.epam.constant.Constants;
import by.epam.constant.RegExForTriangle;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.shape.model.Triangle;
import by.epam.util.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareTrianglesTest {
    private TriangleCreator triangleCreator;

    @BeforeMethod
    public void setUp() throws CouldNotCreateShapeException {
        triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMITER);
    }

    @Test
    public void shouldCompareTrianglesTest() {
        Triangle triangleBeforeChanges = triangleCreator.returnTriangles().get(0);
        Triangle triangleAfterChanges = triangleCreator.returnTriangles().get(1);
        triangleAfterChanges.getPoints().clear();
        triangleAfterChanges.changePoints(triangleBeforeChanges.getPoints());
        assertEquals(triangleAfterChanges, triangleBeforeChanges);
    }
}
