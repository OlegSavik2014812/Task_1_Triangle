package by.epam.action;
import by.epam.shape.model.Triangle;

public interface TriangleObserver {
    void handleChanges(Triangle triangle);
}
