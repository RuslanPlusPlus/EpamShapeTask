package by.ruslan.quadrangle.comparator;

import by.ruslan.quadrangle.action.impl.QuadrangleCalculator;
import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.warehouse.ShapeValue;

import java.util.Comparator;

public class QuadrangleSquareComparator implements Comparator<CustomPlaneShape> {
    @Override
    public int compare(CustomPlaneShape o1, CustomPlaneShape o2) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double square1 = 0;
        double square2 = 0;
        try {
            square1 = calculator.findSquare(o1);
            square2 = calculator.findSquare(o2);
        } catch (ShapeException ignored) {}
        return Double.compare(square1, square2);
    }
}
