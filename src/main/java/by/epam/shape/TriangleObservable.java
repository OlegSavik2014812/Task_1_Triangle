package by.epam.shape;

import by.epam.action.TriangleObserver;

public interface TriangleObservable {
    void addObserver(TriangleObserver triangleObserver);

    void removeObserver(TriangleObserver triangleObserver);

    void notifyObservers();
}
