package pl.coderstrust.figures;

public class Triangle implements Figure {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        if (base <= 0) {
            throw new IllegalArgumentException("Base cannot be lower or equal to zero.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be lower or equal to zero.");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return ((base * height) / 2);
    }
}
