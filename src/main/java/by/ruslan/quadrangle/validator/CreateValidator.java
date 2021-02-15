package by.ruslan.quadrangle.validator;

import by.ruslan.quadrangle.entity.CustomPoint;

public class CreateValidator {
    public static boolean isPossibleToCreateQuadrangle(CustomPoint...points){
        if (points.length != 4){
            return false;
        }
        boolean result = findEqualPoints(points) || threeEqualAbscissas(points) || threeEqualOrdinates(points);
        return !result;
    }

    public static boolean findEqualPoints(CustomPoint...points){
        for (int i = 0; i < points.length - 1; i++){
            for (int j = i + 1; j < points.length; j++){
                if (points[i].equals(points[j])){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean threeEqualAbscissas(CustomPoint...points){
        int counter = 0;
        for (int i = 0; i < points.length - 1; i++){
            for (int j = i + 1; j < points.length; j++){
                if (points[i].getX() == points[j].getX()){
                    counter++;
                }
            }
        }
        return counter >= 3;
    }

    public static boolean threeEqualOrdinates(CustomPoint...points){
        int counter = 0;
        for (int i = 0; i < points.length - 1; i++){
            for (int j = i + 1; j < points.length; j++){
                if (points[i].getY() == points[j].getY()){
                    counter++;
                }
            }
        }
        return counter >= 3;
    }
}
