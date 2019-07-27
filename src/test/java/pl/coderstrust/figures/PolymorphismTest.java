package pl.coderstrust.figures;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class PolymorphismTest {

    @Test
    void polymorphismSquareTest() {
        //given
        Square square = new Square(4);

        //when
        Figure figureSquare = new Square(4);
        Rectangle rectangleSquare = new Square(4);

        //then
        assertEquals(square.calculateArea(), figureSquare.calculateArea(), 0.01);
        assertEquals(square.calculateArea(), rectangleSquare.calculateArea(), 0.01);
    }

    @Test
    void polymorphismCircleTest() {
        //given
        Circle circle = new Circle(4);

        //when
        Figure figureCircle = new Circle(4);

        //then
        assertEquals(circle.calculateArea(), figureCircle.calculateArea(), 0.01);
    }

    @Test
    void polymorphismTriangleTest() {
        //given
        Triangle triangle = new Triangle(4, 3);

        //when
        Figure figureTriangle = new Triangle(4, 3);

        //then
        assertEquals(triangle.calculateArea(), figureTriangle.calculateArea(), 0.01);
    }

    @Test
    void polymorphismTrapezoidTest() {
        //given
        Trapezoid trapezoid = new Trapezoid(4, 3, 5);

        //when
        Figure figureTrapezoid = new Trapezoid(4, 3, 5);

        //then
        assertEquals(trapezoid.calculateArea(), figureTrapezoid.calculateArea(), 0.01);
    }
}
