package pl.coderstrust.figures;

public class Triangle implements Figure {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        if (base < 0 || height <0) {
            throw new IllegalArgumentException("Number cannot be less than 0.");
        } else
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return ((base * height) / 2);
    }
}
