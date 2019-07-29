package pl.coderstrust.figures;

public class Rectangle implements Figure {
    private double width;
    private double length;

    public Rectangle(double length, double width) {
        if (length < 0) {
            throw new IllegalArgumentException("Number cannot be lower than 0.");
        }
        this.length = length;
        if (width < 0) {
            throw new IllegalArgumentException("Number cannot be lower than 0.");
        }
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
