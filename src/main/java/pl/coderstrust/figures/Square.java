package pl.coderstrust.figures;

public class Square extends Rectangle {
    private double side;

    public Square(double side) {
        super(side, side);
        if (side < 0) {
            throw new IllegalArgumentException("Number cannot be less than 0.");
        } else
        this.side = side;
    }
}
