package repository.impl;

import by.ruslan.quadrangle.action.ShapeCalculator;
import by.ruslan.quadrangle.action.impl.QuadrangleCalculator;
import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.exception.ShapeException;
import repository.Specification;

public class PerimeterRangeSpecification implements Specification<CustomPlaneShape> {

    private double minValue;
    private double maxValue;
    private ShapeCalculator calculator;

    public PerimeterRangeSpecification(double minValue, double maxValue, ShapeCalculator calculator){
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.calculator = calculator;
    }

    @Override
    public boolean specify(CustomPlaneShape shape){
        double perimeter;
        boolean result;
        try {
            perimeter = calculator.findPerimeter(shape);
            result = perimeter >= minValue && perimeter <= maxValue;
        } catch (ShapeException e) {
            result = false;
        }
        return result;
    }
}
