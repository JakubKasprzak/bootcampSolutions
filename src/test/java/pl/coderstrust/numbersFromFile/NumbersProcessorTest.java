package pl.coderstrust.numbersFromFile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersProcessorTest {

    @ParameterizedTest
    @DisplayName("Should extract numbers from line and return equation.")
    @MethodSource("numbersProcessorArguments")
    void processLine(String line, String expected) {
        assertEquals(expected, NumbersProcessor.processLine(line));
    }

    private static Stream<Arguments> numbersProcessorArguments() {
        String line1 = "      2      3      5      7     11     13     17     19     23     29 ";
        String line2 = "";
        String line3 = "789 sfhsiudfh  hdsau hua hhfhf 987 ";
        String line4 = "1 1 1 1 1 1";
        String line5 = "                   ";

        String expected1 = "2+3+5+7+11+13+17+19+23+29=129";
        String expected2 = "empty line";
        String expected3 = "789+987=1776";
        String expected4 = "1+1+1+1+1+1=6";
        String expected5 = "empty line";

        return Stream.of(
                Arguments.of(line1, expected1),
                Arguments.of(line2, expected2),
                Arguments.of(line3, expected3),
                Arguments.of(line4, expected4),
                Arguments.of(line5, expected5));
    }
}
