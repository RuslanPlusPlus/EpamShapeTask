package by.ruslan.quadrangle.repository.impl;

import by.ruslan.quadrangle.action.PlaneShapeCalculator;
import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.repository.Specification;

public class PerimeterRangeSpecification implements Specification<CustomPlaneShape> {

    private double minValue;
    private double maxValue;
    private PlaneShapeCalculator calculator;

    public PerimeterRangeSpecification(double minValue, double maxValue, PlaneShapeCalculator calculator){
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
