package pl.coderstrust.figures;

public class Trapezoid implements Figure {
    private double base1;
    private double base2;
    private double height;

    Trapezoid(double base1, double base2, double height) {
        if (base1 < 0 || base2 < 0 || height < 0) {
            throw new IllegalArgumentException("Number cannot be less than 0.");
        } else {
            this.base1 = base1;
        }
        this.base2 = base2;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return ((base1 + base2) / 2) * height;
    }
}
