package repository.impl;

import by.ruslan.quadrangle.entity.CustomPlaneShape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.Repository;
import repository.Specification;

import java.util.*;
import java.util.stream.Collectors;

public class CustomShapeRepository implements Repository<CustomPlaneShape> {

    static final Logger logger = LogManager.getLogger();
    private List<CustomPlaneShape> shapes = new ArrayList<>();
    private static final CustomShapeRepository repository = new CustomShapeRepository();

    public static CustomShapeRepository getInstance(){
        return repository;
    }

    private CustomShapeRepository(){}

    @Override
    public boolean add(CustomPlaneShape shape) {
        return shapes.add(shape);
    }

    @Override
    public boolean remove(CustomPlaneShape shape) {
        return shapes.remove(shape);
    }

    @Override
    public List<CustomPlaneShape> getAll() {
        return Collections.unmodifiableList(shapes);
    }

    @Override
    public Optional<CustomPlaneShape> get(int index) {
        return Optional.of(shapes.get(index));
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

    @Override
    public List<CustomPlaneShape> sort(Comparator<CustomPlaneShape> comparator) {
        shapes.sort(comparator);
        logger.info("Repository values sorted by comparator " + comparator.getClass());
        return shapes;
    }


}
