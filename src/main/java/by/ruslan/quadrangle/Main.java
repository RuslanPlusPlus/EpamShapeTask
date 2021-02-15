package by.ruslan.quadrangle;

import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.parser.DataParser;
import by.ruslan.quadrangle.parser.impl.DataParserImpl;
import by.ruslan.quadrangle.validator.CreateValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        /*String line = "3.3 -45.6 +2 0 -4 89 -4.05 1.09";
        String line_1 = "3.3 9 +2 0 -4 8.45 -4.05 890";
        List<String> linesList = new ArrayList<>();
        linesList.add(line);
        linesList.add(line_1);
        DataParser parser = new DataParserImpl();
        try {
            List<CustomPoint[]> pointsList = parser.parseLines(linesList);
            for (CustomPoint[] array: pointsList){
                for (int i = 0; i < array.length; i++){
                    System.out.println(array[i]);
                }
            }
        } catch (ShapeException e) {
            e.printStackTrace();
        }*/
        CustomPoint pointA = new CustomPoint(3.2, 2.4);
        CustomPoint pointB = new CustomPoint(3.2, 2.7);
        CustomPoint pointC = new CustomPoint(3.6, 2.4);
        CustomPoint pointD = new CustomPoint(3.2, 4.4);
        CustomPoint[] points = new CustomPoint[4];
        points[0] = pointA;
        points[1] = pointB;
        points[2] = pointC;
        points[3] = pointD;
        System.out.println(CreateValidator.isPossibleToCreateQuadrangle(points));

    }
}
