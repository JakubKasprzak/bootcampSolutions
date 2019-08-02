package pl.coderstrust.figures;

public class Circle implements Figure {
    private double radius;
    private static final double pi = Math.PI;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius cannot be lower or equal to zero.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return pi * Math.pow(radius, 2);
    }
}
