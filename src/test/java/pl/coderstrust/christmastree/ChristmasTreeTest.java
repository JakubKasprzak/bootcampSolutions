package pl.coderstrust.christmastree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChristmasTreeTest {

    @ParameterizedTest
    @MethodSource("christmasTreeArguments")
    void shouldReturnProperChristmasTree(int size, List<String> expected) {
        assertEquals(expected, ChristmasTree.getChristmasTree(size));
    }

    private static Stream<Arguments> christmasTreeArguments() {
        List<String> expected5 = Arrays.asList("    *", "   ***", "  *****", " *******", "*********", "    **");
        List<String> expected4 = Arrays.asList("   *", "  ***", " *****", "*******", "   **");
        List<String> expected3 = Arrays.asList("  *", " ***", "*****", "  **");

        return Stream.of(
                Arguments.of(5, expected5),
                Arguments.of(4, expected4),
                Arguments.of(3, expected3));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 0, -10})
    void shouldReturnIllegalArgumentExceptionForInvalidArgument(int size) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> ChristmasTree.getChristmasTree(size));
        assertEquals("Number must be greater than two.", thrown.getMessage());
    }
}
