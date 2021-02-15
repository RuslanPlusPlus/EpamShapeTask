package by.ruslan.quadrangle.validator;

public class DataValidator {

    static final String LINE_FORMAT = "^((\\-|\\+)?\\d+(\\.\\d+)? ){7}(\\-|\\+)?\\d+(\\.\\d+)?$";

    public static boolean isValidLine(String line){
        return line.matches(LINE_FORMAT);
    }

}
