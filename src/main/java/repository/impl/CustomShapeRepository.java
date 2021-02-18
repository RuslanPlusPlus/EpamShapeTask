package repository.impl;

import by.ruslan.quadrangle.entity.CustomPlaneShape;
import repository.Repository;
import repository.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomShapeRepository implements Repository<CustomPlaneShape> {

    private List<CustomPlaneShape> shapes = new ArrayList<>();

    @Override
    public boolean add(CustomPlaneShape shape) {
        return shapes.add(shape);
    }

    @Override
    public boolean remove(CustomPlaneShape shape) {
        return shapes.remove(shape);
    }

    @Override
    public CustomPlaneShape get(int index) {
        return shapes.get(index);
    }

    @Override
    public boolean addAll(Collection<? extends CustomPlaneShape> collection) {
        return shapes.addAll(collection);
    }

    @Override
    public boolean removeAll(Collection<CustomPlaneShape> collection) {
        return shapes.removeAll(collection);
    }

    @Override
    public CustomPlaneShape set(int index, CustomPlaneShape shape) {
        return shapes.set(index, shape);
    }

    @Override
    public List<CustomPlaneShape> query(Specification<CustomPlaneShape> specification) {
        List<CustomPlaneShape> list = shapes.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        return list;
    }


}
