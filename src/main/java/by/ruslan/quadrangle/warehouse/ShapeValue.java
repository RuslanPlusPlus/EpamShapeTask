package by.ruslan.quadrangle.warehouse;

public class ShapeValue {
    private double perimeter;
    private double square;

    public ShapeValue(double perimeter, double square){
        this.perimeter = perimeter;
        this.square = square;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeValue that = (ShapeValue) o;
        return perimeter == that.perimeter &&
                square == that.square;
    }

    @Override
    public int hashCode() {
        int hash = 31;
        int result = 1;
        result = (int) (hash * result + square);
        result = (int) (hash * result + perimeter);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShapeValue{")
                .append("perimeter=")
                .append(perimeter)
                .append(", square=")
                .append(square)
                .append("}");
        return builder.toString();
    }
}
