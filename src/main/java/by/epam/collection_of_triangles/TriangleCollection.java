package by.epam.collection_of_triangles;

import by.epam.shape.model.Triangle;

import java.util.ArrayList;
import java.util.List;

public final class TriangleCollection {
    private static List<Triangle> triangleList;
    private static TriangleCollection instance;

    private TriangleCollection() {
        triangleList = new ArrayList<>();
    }

    public static TriangleCollection getInstance() {
        if (instance == null) {
            instance = new TriangleCollection();
        }
        return instance;
    }

    public static void addTriangle(Triangle triangle) {
        triangleList.add(triangle);
    }

    public static void removeTriangle(Triangle triangle) {
        triangleList.remove(triangle);
    }

    public static List<Triangle> returnTriangleList() {
        return triangleList;
    }
}