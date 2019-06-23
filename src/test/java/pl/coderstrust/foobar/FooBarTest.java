package pl.coderstrust.foobar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

//    @Rule
//    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldReturnIllegalArgumentException() {
        int number = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            FooBar.getFooBar(-1);
        });


//        thrown.expect(IllegalArgumentException.class);
//        thrown.expectMessage("Number must be greater than 0");
//        FooBar.getFooBar(number);

    }
}
