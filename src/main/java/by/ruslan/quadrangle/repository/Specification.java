package by.ruslan.quadrangle.repository;

import by.ruslan.quadrangle.entity.CustomPlaneShape;

public interface Specification<T extends CustomPlaneShape> {
    boolean specify(T t);
}
