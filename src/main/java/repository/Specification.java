package repository;

public interface Specification<T> {
    boolean specify(T t);
}
