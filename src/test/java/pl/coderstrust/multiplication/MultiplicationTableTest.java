package pl.coderstrust.multiplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTableTest {

    @Test
    public void shouldReturnCorrectMultiplicationTable() {
        //given
        int size = 4;
        int[][] expected = {{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};

        //when
        int[][] result = MultiplicationTable.getMultiplicationTable(size);

        //then
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnIllegalArgumentException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            MultiplicationTable.getMultiplicationTable(-1);
        });

        assertEquals("Number must be greater than 0", thrown.getMessage());
    }
}
