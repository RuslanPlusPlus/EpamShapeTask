package by.ruslan.quadrangle.repository.impl;

import by.ruslan.quadrangle.entity.CustomPlaneShape;
import by.ruslan.quadrangle.repository.Specification;

public class IdSpecification implements Specification<CustomPlaneShape> {
    private long id;

    public IdSpecification(long id){
        this.id = id;
    }

    @Override
    public boolean specify(CustomPlaneShape shape) {
        boolean result = id == shape.getId();
        return result;
    }
}
