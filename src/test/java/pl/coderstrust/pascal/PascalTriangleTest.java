import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.coderstrust.pascal.PascalTriangle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PascalTriangleTest {

    @ParameterizedTest
    @MethodSource("pascalTriangleArguments")
    void shouldReturnProperPascalTriangle(int size, List<String> expected) {
        assertEquals(expected, PascalTriangle.getPascalTriangle(size));
    }

    private static Stream<Arguments> pascalTriangleArguments() {
        List<String> expected5 = Arrays.asList(
                "             1",
                "           1   1",
                "         1   2   1",
                "       1   3   3   1",
                "     1   4   6   4   1",
                "   1   5  10  10   5   1");
        List<String> expected4 = Arrays.asList(
                "           1",
                "         1   1",
                "       1   2   1",
                "     1   3   3   1",
                "   1   4   6   4   1");
        List<String> expected3 = Arrays.asList(
                "         1",
                "       1   1",
                "     1   2   1",
                "   1   3   3   1");

        return Stream.of(
                Arguments.of(5, expected5),
                Arguments.of(4, expected4),
                Arguments.of(3, expected3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -5, -10})
    void shouldThrowExceptionForInvalidArgument(int size) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> PascalTriangle.getPascalTriangle(size));
        assertEquals("Number must be greater than 0.", thrown.getMessage());
    }
}
