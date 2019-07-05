package pl.coderstrust.hanoi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class HanoiTowersTest {

    @ParameterizedTest
    @MethodSource("hanoiTowersArguments")
    void shouldReturnCorrectStackOFDiscsOnPile3(int numberOfDiscs, Stack<Integer> expected) throws IOException {
        assertEquals(expected, HanoiTowers.runHanoi(numberOfDiscs));
    }

    private static Stream<Arguments> hanoiTowersArguments() {
        Stack<Integer> expected3 = new Stack<>();
        expected3.push(3);
        expected3.push(2);
        expected3.push(1);

        Stack<Integer> expected4 = new Stack<>();
        expected4.push(4);
        expected4.push(3);
        expected4.push(2);
        expected4.push(1);
        return Stream.of(
                Arguments.of(3, expected3),
                Arguments.of(4, expected4));
    }
}
