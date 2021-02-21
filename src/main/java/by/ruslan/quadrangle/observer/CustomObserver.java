package by.ruslan.quadrangle.observer;

import by.ruslan.quadrangle.exception.ShapeException;

public interface CustomObserver {
    void parameterChanged(QuadrangleEvent event) throws ShapeException;
}
