package by.ruslan.quadrangle.observer.impl;

import by.ruslan.quadrangle.action.impl.QuadrangleCalculator;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.observer.CustomObserver;
import by.ruslan.quadrangle.observer.QuadrangleEvent;
import by.ruslan.quadrangle.warehouse.ShapeValue;
import by.ruslan.quadrangle.warehouse.Warehouse;

public class QuadrangleObserver implements CustomObserver {
    @Override
    public void parameterChanged(QuadrangleEvent event) throws ShapeException {
        CustomQuadrangle quadrangle = event.getSource();
        double perimeter;
        double square;
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        perimeter = calculator.findPerimeter(quadrangle);
        square = calculator.findSquare(quadrangle);
        Warehouse warehouse = Warehouse.getInstance();
        ShapeValue shapeValue = warehouse.getShapeValue(quadrangle.getId());
        if (shapeValue != null){
            shapeValue.setPerimeter(perimeter);
            shapeValue.setSquare(square);
        }
        else {
            shapeValue = new ShapeValue(perimeter, square);
            warehouse.putShapeValue(quadrangle.getId(), shapeValue);
        }
    }
}
