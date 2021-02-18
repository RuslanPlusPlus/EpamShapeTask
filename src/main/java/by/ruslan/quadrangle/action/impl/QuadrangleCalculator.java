package by.ruslan.quadrangle.action.impl;

import by.ruslan.quadrangle.action.ShapeCalculator;
import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.exception.ShapeException;

public class QuadrangleCalculator implements ShapeCalculator {
    @Override
    public double findSquare(CustomPlaneShape shape) {
        return 0;
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
}
