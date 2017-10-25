package by.epam.action.result;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public final class Results {
    public static Result areaIs(double area) {
        return new Result("is " + area, "Calculate area", area);
    }

    public static Result perimeterIs(double perimeter) {
        return new Result("is " + perimeter, "Calculate perimeter", perimeter);
    }

    public static Result orthogonalIs(boolean isOrthogonal) {
        return new Result("is " + isOrthogonal, "CheckTriangleOrthogonal", isOrthogonal);
    }
}
