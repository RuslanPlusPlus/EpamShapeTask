package by.ruslan.quadrangle.repository;

import by.ruslan.quadrangle.entity.CustomPlaneShape;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface Repository<T extends CustomPlaneShape> {
    boolean add(T t);
    boolean remove(T t);
    List<T> getAll();
    Optional<T> get(int index);
    boolean addAll(Collection<? extends T> collection);
    boolean removeAll(Collection<T> collection);
    T set(int index, T t);
    List<T> query(Specification<T> specification);
    List<T> sort(Comparator<T> comparator);
}
