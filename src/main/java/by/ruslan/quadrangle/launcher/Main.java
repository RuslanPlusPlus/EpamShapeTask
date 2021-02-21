package by.ruslan.quadrangle.launcher;

import by.ruslan.quadrangle.action.impl.QuadrangleCalculator;
import by.ruslan.quadrangle.entity.CustomPoint;
import by.ruslan.quadrangle.entity.CustomQuadrangle;
import by.ruslan.quadrangle.exception.ShapeException;
import by.ruslan.quadrangle.factory.CustomQuadrangleFactory;
import by.ruslan.quadrangle.observer.CustomObserver;
import by.ruslan.quadrangle.observer.impl.QuadrangleObserver;
import by.ruslan.quadrangle.warehouse.ShapeValue;
import by.ruslan.quadrangle.warehouse.Warehouse;

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
        CustomPoint[] points = new CustomPoint[4];
        points[0] = new CustomPoint(4,5);
        points[1] = new CustomPoint(6,8);
        points[2] = new CustomPoint(8,5);
        points[3] = new CustomPoint(6,2);
        CustomQuadrangleFactory factory = new CustomQuadrangleFactory();
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        try {
            CustomQuadrangle quadrangle = factory.getInstance("Quad", points);
            System.out.println(quadrangle);
            double diag1 = calculator.findSideLength(points[0], points[2]);
            double diag2 = calculator.findSideLength(points[1], points[3]);
            double angle = Math.toDegrees(calculator.findDiagonalsAngle(quadrangle, diag1, diag2));
            boolean sidesEqual = calculator.findSideLength(points[0], points[1]) == calculator.findSideLength(points[1], points[2]) &&
                    calculator.findSideLength(points[0], points[1]) == calculator.findSideLength(points[2], points[3]) &&
                    calculator.findSideLength(points[0], points[1]) == calculator.findSideLength(points[3], points[0]);
            System.out.println(angle);
            System.out.println(sidesEqual);
            System.out.println(calculator.findSideLength(points[0], points[1]));
            System.out.println(calculator.findSideLength(points[1], points[2]));
            System.out.println(calculator.findSideLength(points[2], points[3]));
            System.out.println(calculator.findSideLength(points[3], points[0]));
        } catch (ShapeException e) {
            e.printStackTrace();
        }
    }

}
