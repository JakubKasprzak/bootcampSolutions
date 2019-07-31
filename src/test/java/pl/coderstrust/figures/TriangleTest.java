package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    @ParameterizedTest
    @MethodSource("triangleArguments")
    void shouldReturnTriangleArea(double base, double hight, double expected) {
        assertEquals(expected, new Triangle(base, hight).calculateArea());
    }

    private static Stream<Arguments> triangleArguments() {
        return Stream.of(
                Arguments.of(1.05, 2.12, 1.1130000000000002),
                Arguments.of(2, 4.45, 4.45),
                Arguments.of(0, 12.56, 0));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -10, -12})
    void shouldThrowIllegalArgumentExceptionForInvalidBaseArgument(double base) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Triangle(5, base).calculateArea());
        assertEquals("Number cannot be less than 0.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -10, -12})
    void shouldThrowIllegalArgumentExceptionForInvalidHeightArgument(double height) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Triangle(height, 5).calculateArea());
        assertEquals("Number cannot be less than 0.", thrown.getMessage());
    }
}
