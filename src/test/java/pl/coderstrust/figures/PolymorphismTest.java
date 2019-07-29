package pl.coderstrust.figures;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class PolymorphismTest {

    @Test
    void polymorphismTest() {
        //given
        Figure figureCircle = new Circle(4);
        Figure figureRectangle = new Rectangle(4, 3);
        Figure figureSquare = new Square(4);
        Figure figureTrapezoid = new Trapezoid(4, 3, 5);
        Figure figureTriangle = new Triangle(4, 3);

        //when
        Circle circle = new Circle(4);
        Rectangle rectangle = new Rectangle(4, 3);
        Square square = new Square(4);
        Trapezoid trapezoid = new Trapezoid(4, 3, 5);
        Triangle triangle = new Triangle(4, 3);

        //then
        assertEquals(circle.calculateArea(), figureCircle.calculateArea(), 0.01);
        assertEquals(rectangle.calculateArea(), figureRectangle.calculateArea(), 0.01);
        assertEquals(square.calculateArea(), figureSquare.calculateArea(), 0.01);
        assertEquals(trapezoid.calculateArea(), figureTrapezoid.calculateArea(), 0.01);
        assertEquals(triangle.calculateArea(), figureTriangle.calculateArea(), 0.01);
    }
}
