package pl.coderstrust.foobar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FooBarTest {

    @ParameterizedTest
    @MethodSource("argumentsForShouldReturnCorrectFooBar")
    void ShouldReturnCorrectFooBar(String[] expected, int number) {
        assertArrayEquals(expected, FooBar.getFooBar(number));
    }

    private static Stream<Arguments> argumentsForShouldReturnCorrectFooBar() {
        String[] expected = {"0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar"};
        return Stream.of(
                Arguments.of(expected, 15));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1})
    void shouldThrowExceptionForInvalidArgument(int number) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> FooBar.getFooBar(number));

        assertEquals("Number cannot be lower than zero.", thrown.getMessage());
    }
}
