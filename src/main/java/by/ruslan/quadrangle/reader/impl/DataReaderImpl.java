package by.ruslan.quadrangle.reader.impl;

import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReaderImpl implements DataReader {

    static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readAllLines(String fileName) throws ShapeException {
        if (fileName == null || fileName.isEmpty()){
            throw new ShapeException("Passed filename is null or empty");
        }
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(fileName);
        try {
            Files.lines(path, Charset.defaultCharset()).forEach(lines::add);
        } catch (IOException e) {
            logger.error("Failed to read file: " + fileName);
            throw new ShapeException("Failed to read file: " + fileName, e);
        }
        logger.info("File " + fileName + " is successfully read");
        return lines;
    }
}
