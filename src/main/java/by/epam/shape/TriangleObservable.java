package by.epam.shape;

import by.epam.action.TriangleObserver;
import by.epam.exception.CouldNotCreateShapeException;

public interface TriangleObservable {
    void addObserver(TriangleObserver triangleObserver);

    void removeObserver(TriangleObserver triangleObserver);

    void notifyObservers() throws CouldNotCreateShapeException;
}
