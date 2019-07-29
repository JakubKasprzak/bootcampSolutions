package pl.coderstrust.figures;

class Square extends Rectangle {
    private double side;

    Square(double side) {
        super(side, side);
        if (side < 0) {
            throw new IllegalArgumentException("Number cannot be less than 0.");
        } else {
            this.side = side;
        }
    }
}
