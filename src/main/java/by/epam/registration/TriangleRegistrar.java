package by.epam.registration;

import by.epam.action.TriangleObserver;
import by.epam.action.impl.CalculateAreaAction;
import by.epam.action.impl.CalculatePerimeterAction;
import by.epam.action.impl.CheckOrthogonalTriangleAction;
import by.epam.shape.model.Triangle;

public class TriangleRegistrar implements TriangleObserver {
    private String areaOfTriangle;
    private String perimeterOfTriangle;
    private String isOrthogonalTriangle;

    @Override
    public void update(Triangle triangle) {
        CalculateAreaAction calculateAreaAction = new CalculateAreaAction();
        CalculatePerimeterAction calculatePerimeterAction = new CalculatePerimeterAction();
        CheckOrthogonalTriangleAction checkOrthogonalTriangleAction = new CheckOrthogonalTriangleAction();
        setAreaOfTriangle(calculateAreaAction.calculate(triangle));
        setPerimeterOfTriangle(calculatePerimeterAction.calculate(triangle));
        setIsOrthogonalTriangle(checkOrthogonalTriangleAction.calculate(triangle));
    }

    private void setAreaOfTriangle(String areaOfTriangle) {
        this.areaOfTriangle = areaOfTriangle;
    }

    private void setPerimeterOfTriangle(String perimeterOfTriangle) {
        this.perimeterOfTriangle = perimeterOfTriangle;
    }

    private void setIsOrthogonalTriangle(String isOrthogonalTriangle) {
        this.isOrthogonalTriangle = isOrthogonalTriangle;
    }

    public String getAreaOfTriangle() {
        return areaOfTriangle;
    }

    public String getPerimeterOfTriangle() {
        return perimeterOfTriangle;
    }

    public String getIsOrthogonalTriangle() {
        return isOrthogonalTriangle;
    }
}
