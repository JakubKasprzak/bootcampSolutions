package pl.coderstrust.figures;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class PolymorphismTest {

    @Test
    void simpleTest() {
        Square square = new Square(4);

        Figure anotherSquare = new Square(4);
        Rectangle yetAnotherSquare = square;
        ((Square) yetAnotherSquare).cokolwiek();

        assertEquals(square.calculateArea(), anotherSquare.calculateArea(), 0.01);
        assertEquals(square.calculateArea(), yetAnotherSquare.calculateArea(), 0.01);
    }
}
