package pl.coderstrust.foobar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FooBarTest {

    @ParameterizedTest
    @MethodSource("fooBarArguments")
    void shouldReturnCorrectFooBar(int number, String[] expected) {
        assertArrayEquals(expected, FooBar.getFooBar(number));
    }

    private static Stream<Arguments> fooBarArguments() {
        String[] expected15 = {"0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar"};
        String[] expected10 = {"0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar"};
        String[] expected5 = {"0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar"};
        String[] expected3 = {"0 FooBar", "1 ", "2 ", "3 Foo"};
        return Stream.of(
                Arguments.of(15, expected15),
                Arguments.of(10, expected10),
                Arguments.of(5, expected5),
                Arguments.of(3, expected3));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10, -15})
    void shouldThrowExceptionForInvalidArgument(int number) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> FooBar.getFooBar(number));
        assertEquals("Number cannot be lower than zero.", thrown.getMessage());
    }
}
