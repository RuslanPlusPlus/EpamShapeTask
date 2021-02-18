package by.ruslan.quadrangle.factory;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.exception.ShapeException;

public class CustomQuadrangleFactory extends CustomShapeFactory{
    @Override
    public CustomQuadrangle getInstance(CustomPoint[] points, String name) throws ShapeException {
        //put the points in right order (check if points form side or diagonal)
        CustomQuadrangle quadrangle = new CustomQuadrangle(points, name);
        return quadrangle;
    }
}
