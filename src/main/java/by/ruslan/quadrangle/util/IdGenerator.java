package by.ruslan.quadrangle.util;

public class IdGenerator {
    private static long IdIncr = 0;

    public static long generateId(){
        return ++IdIncr;
    }
}
