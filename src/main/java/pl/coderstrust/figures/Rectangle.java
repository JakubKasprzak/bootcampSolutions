package pl.coderstrust.figures;

public class Rectangle implements Figure {
    private double width;
    private double length;

    public Rectangle(double length, double width) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be lower or equal to zero.");
        }
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be lower or equal to zero.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
