package pl.coderstrust.hoarepartition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Hoare Partition Test")
class HoarePartitionTest {

    @ParameterizedTest
    @MethodSource("hoarePartitionArguments")
    void shouldReturnCorrectPartition(int[] numbers) {
        //when
        int newPivotIndex = HoarePartition.sort(numbers);

        //then
        for (int i = 0; i < newPivotIndex; i++) {
            assertTrue(numbers[i] < numbers[newPivotIndex]);
        }
        for (int i = newPivotIndex + 1; i <= numbers.length - 1; i++) {
            assertTrue(numbers[i] > numbers[newPivotIndex]);
        }
    }

    private static Stream<Arguments> hoarePartitionArguments() {
        int[] numbers1 = {25, 14, 48, 33, 72, 8, 99};
        int[] numbers2 = {64, 34, 12, 0, 22, 11, 90};
        int[] numbers3 = {34, 12, 13, 22, 11, 90};
        int[] numbers4 = {12, 35, 22, 11, 90};
        int[] numbers5 = {91, 22, 11, 90};
        return Stream.of(
                Arguments.of(numbers1),
                Arguments.of(numbers2),
                Arguments.of(numbers3),
                Arguments.of(numbers4),
                Arguments.of(numbers5));
    }

    @Test
    @DisplayName("Should throw exception for null array")
    void shouldThrowExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.sort(null));
    }

    @Test
    @DisplayName("Should throw exception for an empty array")
    void shouldThrowExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.sort(new int[0]));
    }
}
