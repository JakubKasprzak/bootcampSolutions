package pl.coderstrust.letsSort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class SortingTestBase {
    public abstract SortingMethod getSortingMethod();

    @ParameterizedTest
    @MethodSource("letsSortArguments")
    public void shouldSortSimpleArray(int[] given, int[] expected) {

        long startTime = System.nanoTime();
        int[] result = getSortingMethod().sort(given);
        long endTime = System.nanoTime();
        String name = getSortingMethod().name();
        System.out.println(name + " took: " + (endTime - startTime) + " nanoseconds");
        // then
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> letsSortArguments() {
        int[] given1 = {1};
        int[] given2 = {1, 1};
        int[] given3 = {1, 2, 3, 4, 5};
        int[] given4 = {5, 4, 3, 2, 1};
        int[] expected1 = {1};
        int[] expected2 = {1, 1};
        int[] expected3 = {1, 2, 3, 4, 5};
        int[] expected4 = {1, 2, 3, 4, 5};

        return Stream.of(
                Arguments.of(given1, expected1),
                Arguments.of(given2, expected2),
                Arguments.of(given3, expected3),
                Arguments.of(given4, expected4));
    }

    @Test
    @DisplayName("Should throw exception for null array")
    void shouldThrowExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> getSortingMethod().sort(null));
    }
}
