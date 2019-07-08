package pl.coderstrust.hoarePartition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Hoare Partition Test")
class HoarePartitionTest {

    @ParameterizedTest
    @MethodSource("hoarePartitionArguments")
    void shouldReturnCorrectPartition(int[] numbers, int[] expected) {
        assertArrayEquals(expected, HoarePartition.divide(numbers));
    }

    private static Stream<Arguments> hoarePartitionArguments() {
        int[] numbers1 = {64, 34, 12, 0, 22, 11, 90};
        int[] numbers2 = {34, 12, 13, 22, 11, 90};
        int[] numbers3 = {12, 35, 22, 11, 90};
        int[] numbers4 = {91, 22, 11, 90};
        int[] expected1 = {0, 34, 12, 64, 22, 11, 90};
        int[] expected2 = {12, 13, 11, 22, 34, 90};
        int[] expected3 = {11, 12, 22, 35, 90};
        int[] expected4 = {11, 22, 91, 90};
        return Stream.of(
                Arguments.of(numbers1, expected1),
                Arguments.of(numbers2, expected2),
                Arguments.of(numbers3, expected3),
                Arguments.of(numbers4, expected4));
    }

    @Test
    @DisplayName("Should throw exception for null array")
    void shouldThrowExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.divide(null));
    }

    @Test
    @DisplayName("Should throw exception for an empty array")
    void shouldThrowExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.divide(new int[0]));
    }
}
