package pl.coderstrust.foobar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FooBarTest {

    @Test
    public void shouldReturnCorrectFooBar() {
        //given
        int number = 15;
        String[] expected = {"0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar"};

        //when
        String[] result = FooBar.getFooBar(number);

        //then
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnIllegalArgumentException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            FooBar.getFooBar(-1);
        });

        assertEquals("Number must be greater than 0", thrown.getMessage());
    }
}
