package by.ruslan.quadrangle.action.impl;

import by.ruslan.quadrangle.action.ShapeCalculator;
import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomShape;

public class TriangleCalculator implements ShapeCalculator {
    @Override
    public double findSquare(CustomShape shape) {
        return 0;
    }

    public double findSideLength(CustomPoint pointA, CustomPoint pointB){
        double dx = pointA.getX() - pointB.getX();
        double dy = pointA.getY() - pointB.getY();
        double result = Math.sqrt(dx*dx + dy*dy);
        return result;
    }
}
