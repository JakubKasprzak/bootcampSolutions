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
//        String[] result = FooBar.getFooBar(number);
        assertArrayEquals(expected, FooBar.getFooBar(number));
    }

    private static Stream<Arguments> argumentsForShouldReturnCorrectFooBar() {
        return Stream.of(
                Arguments.of(int a, 15),
        a = 5;
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1})
    void shouldThrowExceptionForInvalidArgument(int number) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> FooBar.getFooBar(number));

        assertEquals("Number cannot be lower than zero.", thrown.getMessage());
    }
}
