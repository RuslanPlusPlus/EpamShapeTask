package by.ruslan.quadrangle.validator;

import by.ruslan.quadrangle.entity.CustomPoint;

public class DiagonalValidator {

    public static boolean isPointOneThreeDiagonal(CustomPoint[] points) {
        double[] coefficients = findCoefficients(points[0], points[2]);
        double[] results = new double[2];
        results[0] = findEquationStraightLine(coefficients, points[1]);
        results[1] = findEquationStraightLine(coefficients, points[3]);
        boolean isDiagonal = results[0] < 0 && results[1] > 0 || results[0] > 0 && results[1] < 0;
        return isDiagonal;
    }

    private static double findEquationStraightLine(double[] coefficients, CustomPoint point) {
        return (point.getX() * coefficients[0] + point.getY() * coefficients[1] + coefficients[2]);
    }

    private static double[] findCoefficients(CustomPoint pointOne, CustomPoint pointTwo) {
        double[] coefficients = new double[3];
        coefficients[0] = pointOne.getY() - pointTwo.getY();
        coefficients[1] = pointTwo.getX() - pointOne.getX();
        coefficients[2] = pointOne.getX() * pointTwo.getY() - pointTwo.getX() * pointOne.getY();
        return coefficients;
    }
}
