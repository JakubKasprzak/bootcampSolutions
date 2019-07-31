package pl.coderstrust.figures;

public class Trapezoid implements Figure {
    private double base1;
    private double base2;
    private double height;

    public Trapezoid(double base1, double base2, double height) {
        if (base1 < 0) {
            throw new IllegalArgumentException("Base1 cannot be lower than 0.");
        }
        if (base2 < 0) {
            throw new IllegalArgumentException("Base2 cannot be lower than 0.");
        }
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be lower than 0.");
        }
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return ((base1 + base2) / 2) * height;
    }
}
