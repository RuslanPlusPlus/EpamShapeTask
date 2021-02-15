package by.ruslan.quadrangle.reader;

import by.ruslan.quadrangle.exception.ShapeException;

import java.util.List;

public interface DataReader {
    List<String> readAllLines(String fileName) throws ShapeException;
}
