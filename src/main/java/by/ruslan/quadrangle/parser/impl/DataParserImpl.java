package by.ruslan.quadrangle.parser.impl;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.parser.DataParser;
import by.ruslan.quadrangle.validator.DataValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataParserImpl implements DataParser {

    static final int POINTS_ARRAY_SIZE = 4;
    static final String SPLITTER = " ";

    @Override
    public List<CustomPoint[]> parseLines(List<String> lines) throws ShapeException {
        if (lines == null){
            throw new ShapeException("Null passed");
        }
        if (lines.size() == 0){
            throw new ShapeException("Cannot parse list of lines. The size is zero");
        }
        List<CustomPoint[]> pointsArraysList = new ArrayList<>();
        for (String line: lines){
            Optional<CustomPoint[]> pointsArray = parseLine(line);
            pointsArray.ifPresent(pointsArraysList::add);
        }
        if (pointsArraysList.isEmpty()){
            throw new ShapeException("No valid lines found to parse");
        }
        return pointsArraysList;

    }

    @Override
    public Optional<CustomPoint[]> parseLine(String line) throws ShapeException {
        if (line == null){
            throw new ShapeException("Null passed");
        }
        if (!DataValidator.isValidLine(line)){
            return Optional.empty();
        }
        CustomPoint[] points = new CustomPoint[POINTS_ARRAY_SIZE];
        String[] coordinates = line.split(SPLITTER);
        int pointCounter = 0;
        for (int i = 0; i < POINTS_ARRAY_SIZE; i++){
            double x = Double.parseDouble(coordinates[pointCounter]);
            double y = Double.parseDouble(coordinates[pointCounter + 1]);
            CustomPoint point = new CustomPoint(x, y);
            points[i] = point;
            pointCounter += 2;
        }
        return Optional.of(points);
    }
}
