package by.ruslan.quadrangle.action.impl;

import by.ruslan.quadrangle.action.ShapeCalculator;
import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.entity.CustomShape;
import by.ruslan.quadrangle.exception.ShapeException;

public class QuadrangleCalculator implements ShapeCalculator {
    @Override
    public double findSquare(CustomShape shape) {
        return 0;
    }

    public double findPerimeter(CustomQuadrangle quadrangle) throws ShapeException {
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
}
