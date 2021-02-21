package by.ruslan.quadrangle.comparator;

import by.ruslan.quadrangle.action.impl.QuadrangleCalculator;
import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.exception.ShapeException;

import java.util.Comparator;

public class QuadranglePerimeterComparator implements Comparator<CustomPlaneShape> {
    @Override
    public int compare(CustomPlaneShape o1, CustomPlaneShape o2) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double perimeter1 = 0;
        double perimeter2 = 0;
        try {
            perimeter1 = calculator.findPerimeter(o1);
            perimeter2 = calculator.findPerimeter(o2);
        } catch (ShapeException ignored) {}
        return Double.compare(perimeter1, perimeter2);
    }
}
