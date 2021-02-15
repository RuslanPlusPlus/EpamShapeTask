package by.ruslan.quadrangle.parser;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.exception.ShapeException;

import java.util.List;
import java.util.Optional;

public interface DataParser {
    List<CustomPoint[]> parseLines(List<String> lines) throws ShapeException;
    Optional<CustomPoint[]> parseLine(String line) throws ShapeException;
}
