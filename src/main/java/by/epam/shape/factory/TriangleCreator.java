package by.epam.shape.factory;

import by.epam.collection_of_triangles.TriangleCollection;
import by.epam.exception.CouldNotCreateShapeException;
import by.epam.registration.TriangleRegistrar;
import by.epam.shape.model.Point;
import by.epam.shape.model.Triangle;
import by.epam.validation.impl.ShapeValidator;
import by.epam.validation.impl.TriangleValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public final class TriangleCreator extends ShapeCreator {
    private List<Triangle> triangles;

    public TriangleCreator() {
        this.triangles = new ArrayList<>();
    }

    @Override
    public void create(String line, String delimiter) throws CouldNotCreateShapeException {

        PointCreator pointCreator = new PointCreator();
        List<Point> points = pointCreator.create(line, delimiter);
        Triangle triangle = new Triangle(points);
        ShapeValidator shapeValidator = new ShapeValidator();
        TriangleValidator triangleValidator = new TriangleValidator();

        boolean isTriangleValid = shapeValidator
                .setNext(triangleValidator)
                .validate(triangle);

        if (isTriangleValid) {
            triangle.addObserver(TriangleRegistrar.getInstance());
            TriangleCollection triangleCollection= TriangleCollection.getInstance();
            triangleCollection.addTriangle(triangle);
        }
    }

    public List<Triangle> returnTriangles() {
        return TriangleCollection.returnTriangleList();
    }
}
