package by.epam.collection_of_triangles;

import by.epam.shape.model.Triangle;

import java.util.ArrayList;
import java.util.List;

public final class TriangleCollection {
    private static List<Triangle> triangleList;

    private TriangleCollection() {
        triangleList = new ArrayList<>();
    }

    private static class TriangleCollectionHolder {
        private final static TriangleCollection instance = new TriangleCollection();
    }

    public static TriangleCollection getInstance() {
        return TriangleCollectionHolder.instance;
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
