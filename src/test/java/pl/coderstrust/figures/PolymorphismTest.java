package pl.coderstrust.figures;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class PolymorphismTest {

    @Test
    void polymorphismTest() {
        Figure figure = new Circle(4);
        assertEquals(50.26, figure.calculateArea(), 0.01);
        figure = new Rectangle(4, 3);
        assertEquals(12, figure.calculateArea(), 0.01);
        figure = new Square(4);
        assertEquals(16, figure.calculateArea(), 0.01);
        figure = new Trapezoid(4, 3, 5);
        assertEquals(17.5, figure.calculateArea(), 0.01);
        figure = new Triangle(4, 3);
        assertEquals(6, figure.calculateArea(), 0.01);
    }
}
