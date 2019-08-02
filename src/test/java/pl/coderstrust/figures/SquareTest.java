package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTest {

    @ParameterizedTest
    @MethodSource("squareArguments")
    void shouldReturnSquareArea(double side, double expected) {
        assertEquals(expected, new Square(side).calculateArea());
    }

    private static Stream<Arguments> squareArguments() {
        return Stream.of(
                Arguments.of(1.05, 1.1025),
                Arguments.of(2, 4),
                Arguments.of(10, 100));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -10, -12})
    void shouldThrowIllegalArgumentExceptionForInvalidArgument(double radius) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Square(radius));
        assertEquals("Number cannot be less than 0.", thrown.getMessage());
    }
}
