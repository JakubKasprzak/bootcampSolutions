package pl.coderstrust.figures;

public class Rectangle implements Figure {
    private double width;
    private double length;

    public Rectangle(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Number cannot be less than 0.");
        } else {
            this.length = length;
        }
        this.width = width;
    }

    void dupa() {
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
