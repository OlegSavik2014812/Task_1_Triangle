package by.epam.shape.model;

import by.epam.constant.RegExForTriangle;
import by.epam.shape.TriangleObservable;
import by.epam.action.TriangleObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg Savik on 06.10.2017.
 */
public class Triangle implements TriangleObservable {
    private List<TriangleObserver> triangleObservers = new ArrayList<>();
    private List<Point> pointList = new ArrayList<>();

    public Triangle(List<Point> insertPoints) {
        pointList = new ArrayList<>();
        pointList = insertPoints;
    }

    public void changePoints(List<Point> pointList) {
        this.pointList = pointList;
        notifyObservers();
    }

    public List<Point> getPoints() {
        return pointList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pointList.get(0).hashCode();
        result = prime * result + pointList.get(1).hashCode();
        result = prime * result + pointList.get(2).hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) obj;
        return getPoints().get(0) == triangle.pointList.get(0) && getPoints().get(1) == triangle.pointList.get(1) && getPoints().get(2) == triangle.pointList.get(2);
    }

    @Override
    public String toString() {
        String s = null;
        for (Point point : pointList) {
            s += point + RegExForTriangle.DELIMITER;
        }
        return s;
    }

    @Override
    public void addObserver(TriangleObserver triangleObserver) {
        triangleObservers.add(triangleObserver);
    }

    @Override
    public void removeObserver(TriangleObserver triangleObserver) {
        triangleObservers.remove(triangleObserver);
    }

    @Override
    public void notifyObservers() {
        for (TriangleObserver triangleObserver : triangleObservers) {
            triangleObserver.update(this);
        }
    }
}