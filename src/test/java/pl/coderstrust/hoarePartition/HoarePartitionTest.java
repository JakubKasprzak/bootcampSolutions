package pl.coderstrust.hoarePartition;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HoarePartitionTest {

    @ParameterizedTest
    @MethodSource("hoarePartitionArguments")
    void shouldReturnCorrectPartition(int[] numbers, int[] expected) {
        assertArrayEquals(expected, HoarePartition.divide(numbers));
    }

    private static Stream<Arguments> hoarePartitionArguments() {
        int[] numbers1 = {64, 34, 12, 0, 22, 11, 90};
        int[] numbers2 = {64, 34, 12, 13, 22, 11, 90};
        int[] numbers3 = {64, 34, 12, 35, 22, 11, 90};
        int[] numbers4 = {64, 34, 12, 91, 22, 11, 90};
        int[] expected1 = {0, 34, 12, 64, 22, 11, 90};
        int[] expected2 = {11, 12, 13, 64, 22, 34, 90};
        int[] expected3 = {34, 12, 11, 22, 35, 64, 90};
        int[] expected4 = {34, 12, 64, 22, 11, 90, 91};
        return Stream.of(
                Arguments.of(numbers1, expected1),
                Arguments.of(numbers2, expected2),
                Arguments.of(numbers3, expected3),
                Arguments.of(numbers4, expected4));
    }

    @ParameterizedTest
    @MethodSource("hoarePartitionNullArgument")
    void shouldThrowExceptionForInvalidArgument(int[] numbers) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> HoarePartition.divide(numbers));
        assertEquals("Array cannot be null", thrown.getMessage());
    }

    private static Stream<Arguments> hoarePartitionNullArgument() {
        return Stream.of(
                Arguments.of((Object) null));
    }
}
