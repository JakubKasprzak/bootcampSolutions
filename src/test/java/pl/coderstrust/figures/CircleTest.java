package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleTest {

    @ParameterizedTest
    @MethodSource("circleArguments")
    void shouldReturnCircleArea(double radius, double expected) {
        assertEquals(expected, new Circle(radius).calculateArea());
    }

    private static Stream<Arguments> circleArguments() {
        return Stream.of(
                Arguments.of(3, 28.274333882308138),
                Arguments.of(1, 3.141592653589793),
                Arguments.of(2, 12.566370614359172));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -10, -12})
    void shouldThrowIllegalArgumentExceptionForInvalidArgument(double radius) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Circle(radius));
        assertEquals("Radius cannot be lower or equal to zero.", thrown.getMessage());
    }
}
