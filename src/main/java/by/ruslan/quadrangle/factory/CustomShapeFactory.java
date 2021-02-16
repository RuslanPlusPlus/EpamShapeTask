package by.ruslan.quadrangle.factory;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomShape;
import by.ruslan.quadrangle.exception.ShapeException;

public abstract class CustomShapeFactory {
    public abstract CustomShape getInstance(CustomPoint[] points, String name) throws ShapeException;
}
