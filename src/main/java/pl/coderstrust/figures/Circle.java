package pl.coderstrust.figures;

public class Circle implements Figure {
    private double radius;
    private static final double pi = Math.PI;

    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Number cannot be lower than 0.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return pi * Math.pow(radius, 2);
    }
}
