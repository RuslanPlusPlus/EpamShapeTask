package by.ruslan.quadrangle.action.impl;

import by.ruslan.quadrangle.action.PlaneShapeCalculator;
import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.exception.ShapeException;

public class QuadrangleCalculator implements PlaneShapeCalculator {
    @Override
    public double findSquare(CustomPlaneShape shape) throws ShapeException {
        if (shape.getClass() != CustomQuadrangle.class){
            throw new ShapeException("Not compatible class. CustomQuadrangle object must be passed!");
        }
        CustomQuadrangle quadrangle = (CustomQuadrangle) shape;
        CustomPoint[] points = quadrangle.getPoints();
        double diagonal1 = findSideLength(points[0], points[2]);
        double diagonal2 = findSideLength(points[1], points[3]);
        double angle = findDiagonalsAngle(quadrangle, diagonal1, diagonal2);
        double area = 0.5 * diagonal1 * diagonal2 * Math.sin(angle);
        return area;
    }

    @Override
    public double findPerimeter(CustomPlaneShape shape) throws ShapeException {
        if (shape.getClass() != CustomQuadrangle.class){
            throw new ShapeException("Not compatible class. CustomQuadrangle object must be passed!");
        }
        CustomQuadrangle quadrangle = (CustomQuadrangle) shape;
        CustomPoint pointA = quadrangle.getPointA();
        CustomPoint pointB = quadrangle.getPointB();
        CustomPoint pointC = quadrangle.getPointC();
        CustomPoint pointD = quadrangle.getPointD();
        double sideAB = findSideLength(pointA, pointB);
        double sideBC = findSideLength(pointB, pointC);
        double sideCD = findSideLength(pointC, pointD);
        double sideAD = findSideLength(pointA, pointD);
        return sideAB + sideBC + sideCD + sideAD;
    }

    public double findSideLength(CustomPoint pointA, CustomPoint pointB){
        double dx = pointA.getX() - pointB.getX();
        double dy = pointA.getY() - pointB.getY();
        double result = Math.sqrt(dx*dx + dy*dy);
        return result;
    }

    public double findDiagonalsAngle(CustomQuadrangle quadrangle, double diagonal1, double diagonal2){
        CustomPoint[] points = quadrangle.getPoints();
        CustomPoint firstDiagonalVector = new CustomPoint(points[2].getX() - points[0].getX(), points[2].getY() - points[0].getY());
        CustomPoint secondDiagonalVector = new CustomPoint(points[3].getX() - points[1].getX(), points[3].getY() - points[1].getY());
        double angle = Math.acos(
                (firstDiagonalVector.getX() * secondDiagonalVector.getX() + firstDiagonalVector.getY() * secondDiagonalVector.getY())
                / (diagonal1 * diagonal2));
        return angle;
    }

}
