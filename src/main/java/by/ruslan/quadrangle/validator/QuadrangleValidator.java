package by.ruslan.quadrangle.validator;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;

public class QuadrangleValidator {
    public static boolean isQuadrate(CustomQuadrangle quadrangle){
        CustomPoint[] points = quadrangle.getPoints();
        double diagonal1 = findSideLength(points[0], points[2]);
        double diagonal2 = findSideLength(points[1], points[3]);
        return diagonal1 == diagonal2;
    }

    public static boolean isRhombus(CustomQuadrangle quadrangle){
        CustomPoint[] points = quadrangle.getPoints();
        double diagonal1 = findSideLength(points[0], points[2]);
        double diagonal2 = findSideLength(points[1], points[3]);
        boolean sidesEqual = findSideLength(points[0], points[1]) == findSideLength(points[1], points[2]) &&
                findSideLength(points[0], points[1]) == findSideLength(points[2], points[3]) &&
                findSideLength(points[0], points[1]) == findSideLength(points[3], points[0]);
        double radianAngle = findDiagonalsAngle(quadrangle, diagonal1, diagonal2);
        double diagonalAngle = Math.toDegrees(radianAngle);
        boolean result = sidesEqual && diagonalAngle == 90;
        return result;
    }

    private static double findDiagonalsAngle(CustomQuadrangle quadrangle, double diagonal1, double diagonal2){
        CustomPoint[] points = quadrangle.getPoints();
        CustomPoint firstDiagonalVector = new CustomPoint(points[2].getX() - points[0].getX(), points[2].getY() - points[0].getY());
        CustomPoint secondDiagonalVector = new CustomPoint(points[3].getX() - points[1].getX(), points[3].getY() - points[1].getY());
        double angle = Math.acos(
                (firstDiagonalVector.getX() * secondDiagonalVector.getX() + firstDiagonalVector.getY() * secondDiagonalVector.getY())
                        / (diagonal1 * diagonal2));
        return angle;
    }

    private static double findSideLength(CustomPoint pointA, CustomPoint pointB){
        double dx = pointA.getX() - pointB.getX();
        double dy = pointA.getY() - pointB.getY();
        double result = Math.sqrt(dx*dx + dy*dy);
        return result;
    }


}
