package repository.impl;

import by.ruslan.quadrangle.entity.CustomShape;
import repository.IRepository;
import repository.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomShapeRepository implements IRepository<CustomShape> {

    private List<CustomShape> shapes = new ArrayList<>();

    @Override
    public boolean add(CustomShape shape) {
        return shapes.add(shape);
    }

    @Override
    public boolean remove(CustomShape shape) {
        return shapes.remove(shape);
    }

    @Override
    public CustomShape get(int index) {
        return shapes.get(index);
    }

    @Override
    public boolean addAll(Collection<? extends CustomShape> collection) {
        return shapes.addAll(collection);
    }

    @Override
    public boolean removeAll(Collection<CustomShape> collection) {
        return shapes.removeAll(collection);
    }

    @Override
    public CustomShape set(int index, CustomShape shape) {
        return shapes.set(index, shape);
    }

    @Override
    public List<CustomShape> query(Specification<CustomShape> specification) {
        List<CustomShape> list = shapes.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        return list;
    }
}
