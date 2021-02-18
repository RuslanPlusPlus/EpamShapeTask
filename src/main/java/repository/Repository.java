package repository;

import by.ruslan.quadrangle.entity.CustomPlaneShape;

import java.util.Collection;
import java.util.List;

public interface Repository<T extends CustomPlaneShape> {
    boolean add(T t);
    boolean remove(T t);
    T get(int index);
    boolean addAll(Collection<? extends T> collection);
    boolean removeAll(Collection<T> collection);
    T set(int index, T t);
    List<T> query(Specification<T> specification);
    //sort
}
