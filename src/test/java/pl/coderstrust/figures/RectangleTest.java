package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RectangleTest {

    @ParameterizedTest
    @MethodSource("rectangleArguments")
    void shouldReturnRectangleArea(double length, double width, double expected) {
        assertEquals(expected, new Rectangle(length, width).calculateArea());
    }

    private static Stream<Arguments> rectangleArguments() {
        return Stream.of(
                Arguments.of(1.05, 2.12, 2.2260000000000004),
                Arguments.of(2, 4.45, 8.9),
                Arguments.of(3, 12.56, 37.68));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -10, -12})
    void shouldThrowIllegalArgumentExceptionForInvalidWidthArgument(double width) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Rectangle(5, width));
        assertEquals("Width cannot be lower or equal to zero.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -10, -12})
    void shouldThrowIllegalArgumentExceptionForInvalidLengthArgument(double length) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Rectangle(length, 5));
        assertEquals("Length cannot be lower or equal to zero.", thrown.getMessage());
    }
}
