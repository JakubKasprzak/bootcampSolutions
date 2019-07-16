package pl.coderstrust.isthatfibonacci;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IsThatFibonacciNumberCacheTest {

    @ParameterizedTest
    @MethodSource("fibonacciArguments")
    void shouldReturnCorrectAssignment(long number, boolean expected) {
        assertEquals(expected, IsThatFibonacciNumberCache.checkNumber(number));
    }
    private static Stream<Arguments> fibonacciArguments() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(4, false),
                Arguments.of(5, true),
                Arguments.of(10, false),
                Arguments.of(13, true),
                Arguments.of(15, false));
    }
}
