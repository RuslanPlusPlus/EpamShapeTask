package by.ruslan.quadrangle.entity;

public class CustomPoint implements Cloneable{
    private double x;
    private double y;

    public CustomPoint(){}

    public CustomPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomPoint point = (CustomPoint) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = (int) (result * hash + x);
        result = (int) (result * hash + y);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Point[")
                .append("x = " + x + ", ")
                .append("y = " + y)
                .append("]");
        return builder.toString();
    }

    public CustomPoint clone() throws CloneNotSupportedException {
        return (CustomPoint) super.clone();
    }
}
