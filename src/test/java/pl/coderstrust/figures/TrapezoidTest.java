package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TrapezoidTest {

    @ParameterizedTest
    @MethodSource("trapezoidArguments")
    void shouldReturnTrapezoidArea(double base1, double base2, double height, double expected) {
        assertEquals(expected, new Trapezoid(base1, base2, height).calculateArea());
    }

    private static Stream<Arguments> trapezoidArguments() {
        return Stream.of(
                Arguments.of(1.05, 2.12, 2.2260000000000004, 3.5282100000000005),
                Arguments.of(2, 4.45, 8.9, 28.7025),
                Arguments.of(0, 12.56, 0, 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -12})
    void shouldReturnIllegalArgumentExceptionForInvalidBase1Argument(double base1) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Trapezoid(base1,5,5).calculateArea());
        assertEquals("Number cannot be less than 0.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -12})
    void shouldReturnIllegalArgumentExceptionForInvalidBase2Argument(double base2) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Trapezoid(5, base2,5).calculateArea());
        assertEquals("Number cannot be less than 0.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -12})
    void shouldReturnIllegalArgumentExceptionForInvalidHeightArgument(double height) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Trapezoid(5,5, height).calculateArea());
        assertEquals("Number cannot be less than 0.", thrown.getMessage());
    }
}
