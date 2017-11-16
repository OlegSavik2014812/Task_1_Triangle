package by.epam;

import by.epam.collection_of_triangles.TriangleCollection;
import by.epam.constant.Constants;
import by.epam.constant.RegExForTriangle;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.shape.factory.TriangleCreator;
import by.epam.shape.model.Point;
import by.epam.shape.model.Triangle;
import by.epam.util.FileUtils;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class App {
    public static void main(String[] args) throws CouldNotCreateShapeException {
        TriangleCreator triangleCreator = new TriangleCreator();
        triangleCreator.createFromFile(FileUtils.openFile(Constants.PATH_OF_FILE), RegExForTriangle.DELIMITER);
        System.out.println(TriangleCollection.returnTriangleList());
        /*Triangle triangle = triangleCreator.returnTriangles().get(0);
        triangle.getPoints().remove(0);
        triangle.getPoints().add(0, new Point(0, 4));
        triangle.getPoints().remove(1);
        triangle.getPoints().add(1, new Point(3, 0));
        triangle.changePoints(triangle.getPoints());*/
    }
}




