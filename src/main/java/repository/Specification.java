package repository;

import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.exception.ShapeException;

public interface Specification<T extends CustomPlaneShape> {
    boolean specify(T t);
}
