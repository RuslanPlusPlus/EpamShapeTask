package by.ruslan.quadrangle.factory;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.exception.ShapeException;

public abstract class CustomShapeFactory {
    public abstract CustomPlaneShape getInstance(CustomPoint[] points, String name) throws ShapeException;
}
