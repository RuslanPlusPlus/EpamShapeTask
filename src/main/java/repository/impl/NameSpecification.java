package repository.impl;

import by.ruslan.quadrangle.entity.CustomPlaneShape;
import repository.Specification;

public class NameSpecification implements Specification<CustomPlaneShape> {
    private String name;

    public NameSpecification(String name){
        this.name = name;
    }

    @Override
    public boolean specify(CustomPlaneShape shape) {
        boolean result = name.equals(shape.getName());
        return result;
    }
}
