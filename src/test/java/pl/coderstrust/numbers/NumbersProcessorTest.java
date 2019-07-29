package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersProcessorTest {
    private NumbersProcessor numbersProcessor = new NumbersProcessor();

    @ParameterizedTest
    @DisplayName("Should extract numbers from line and return equation made of them.")
    @MethodSource("numbersProcessorArguments")
    void shouldReturnCorrectSumOfNumbersForProvidedLine(String line, String expected) {
        assertEquals(expected, numbersProcessor.processLine(line));
    }

    private static Stream<Arguments> numbersProcessorArguments() {
        String line1 = "      2      3      5      7     11     13     17     19     23     29 ";
        String line2 = "1 1 1 1 1 1";
        String line3 = "123     31 344 2344     1      2";

        String expected1 = "2+3+5+7+11+13+17+19+23+29=129";
        String expected2 = "1+1+1+1+1+1=6";
        String expected3 = "123+31+344+2344+1+2=2845";

        return Stream.of(
                Arguments.of(line1, expected1),
                Arguments.of(line2, expected2),
                Arguments.of(line3, expected3));
    }

    @ParameterizedTest
    @DisplayName("Should return empty string for invalid line.")
    @ValueSource(strings = {"", "                   ", " a sdfhdsu ahl@#$#$%sdhdsh.,  dfwrf fhv"})
    void shouldReturnEmptyStringForInvalidLine(String strings) {
        String expected = "";
        assertEquals(expected, numbersProcessor.processLine(strings));
    }
}
