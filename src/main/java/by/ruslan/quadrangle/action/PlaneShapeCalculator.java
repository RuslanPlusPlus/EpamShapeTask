package by.ruslan.quadrangle.action;

import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.exception.ShapeException;

public interface PlaneShapeCalculator {
    double findSquare(CustomPlaneShape shape) throws ShapeException;
    double findPerimeter(CustomPlaneShape shape) throws ShapeException;
}
