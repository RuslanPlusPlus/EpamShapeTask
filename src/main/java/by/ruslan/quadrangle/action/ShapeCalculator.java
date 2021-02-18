package by.ruslan.quadrangle.action;

import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.exception.ShapeException;

public interface ShapeCalculator {
    double findSquare(CustomPlaneShape shape);
    double findPerimeter(CustomPlaneShape shape) throws ShapeException;
}
