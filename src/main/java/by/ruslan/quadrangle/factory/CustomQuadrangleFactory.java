package by.ruslan.quadrangle.factory;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.validator.CreateValidator;
import by.ruslan.quadrangle.validator.DiagonalValidator;

import java.util.Arrays;

public class CustomQuadrangleFactory extends CustomShapeFactory{
    @Override
    public CustomQuadrangle getInstance(String name, CustomPoint...points) throws ShapeException {
        //put the points in right order (check if points form side or diagonal)
        if (!CreateValidator.isPossibleToCreateQuadrangle(points)){
            throw new ShapeException("Impossible to create quadrangle with such points " + Arrays.toString(points));
        }
        sortPointsInTraversingOrder(points);
        CustomQuadrangle quadrangle = new CustomQuadrangle(name, points);
        return quadrangle;
    }

    public static void sortPointsInTraversingOrder(CustomPoint[] points) {
        for (int i = 1; i < 3; i++) {
            if (!DiagonalValidator.isPointOneThreeDiagonal(points)) {
                swap(points, i, i + 1);
            }
        }
    }

    private static void swap(CustomPoint[] points, int index1, int index2) {
        CustomPoint tmp = points[index1];
        points[index1] = points[index2];
        points[index2] = tmp;
    }
}
