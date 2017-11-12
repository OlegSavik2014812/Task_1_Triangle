package by.epam.registration;

import by.epam.action.TriangleObserver;
import by.epam.action.impl.CalculateAreaAction;
import by.epam.action.impl.CalculatePerimeterAction;
import by.epam.action.impl.CheckOrthogonalTriangleAction;
import by.epam.shape.model.Triangle;

public class TriangleRegistrar implements TriangleObserver {
    private static String areaOfTriangle;
    private static String perimeterOfTriangle;
    private static String isOrthogonalTriangle;

    private TriangleRegistrar() {
    }

    @Override
    public void update(Triangle triangle) {
        CalculateAreaAction calculateAreaAction = new CalculateAreaAction();
        CalculatePerimeterAction calculatePerimeterAction = new CalculatePerimeterAction();
        CheckOrthogonalTriangleAction checkOrthogonalTriangleAction = new CheckOrthogonalTriangleAction();
        setAreaOfTriangle(calculateAreaAction.calculate(triangle));
        setPerimeterOfTriangle(calculatePerimeterAction.calculate(triangle));
        setIsOrthogonalTriangle(checkOrthogonalTriangleAction.calculate(triangle));
    }

    private static class RegHolder {
        private final static TriangleRegistrar TRIANGLE_REGISTRAR = new TriangleRegistrar();
    }

    public static TriangleRegistrar getInstance() {
        return RegHolder.TRIANGLE_REGISTRAR;
    }

    public static String getAreaOfTriangle() {
        return areaOfTriangle;
    }

    public static void setAreaOfTriangle(String areaOfTriangle) {
        TriangleRegistrar.areaOfTriangle = areaOfTriangle;
    }

    public static String getPerimeterOfTriangle() {
        return perimeterOfTriangle;
    }

    public static void setPerimeterOfTriangle(String perimeterOfTriangle) {
        TriangleRegistrar.perimeterOfTriangle = perimeterOfTriangle;
    }

    public static String getIsOrthogonalTriangle() {
        return isOrthogonalTriangle;
    }

    public static void setIsOrthogonalTriangle(String isOrthogonalTriangle) {
        TriangleRegistrar.isOrthogonalTriangle = isOrthogonalTriangle;
    }
}
