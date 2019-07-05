package pl.coderstrust.multiplication;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTableTest {

    @ParameterizedTest
    @MethodSource("multiplicationTableArguments")
    void shouldReturnCorrectMultiplicationTable(int size, int[][] expected) {
        assertArrayEquals(expected, MultiplicationTable.getMultiplicationTable(size));
    }

    private static Stream<Arguments> multiplicationTableArguments() {
        int[][] expected4 = {{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        int[][] expected3 = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        int[][] expected2 = {{1, 2}, {2, 4}};
        return Stream.of(
                Arguments.of(4, expected4),
                Arguments.of(3, expected3),
                Arguments.of(2, expected2));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10, -15})
    void shouldThrowExceptionForInvalidArgument(int number) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> MultiplicationTable.getMultiplicationTable(number));
        assertEquals("Number must be greater than 0", thrown.getMessage());
    }
}
