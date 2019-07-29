package pl.coderstrust.figures;

class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
        if (side < 0) {
            throw new IllegalArgumentException("Number cannot be lower than 0.");
        }
    }
}
