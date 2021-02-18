package by.ruslan.quadrangle.generator;

public class IdGenerator {
    private static long IdIncr = 0;

    public static long generateId(){
        return ++IdIncr;
    }
}
