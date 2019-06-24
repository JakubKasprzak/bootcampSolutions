package pl.coderstrust.christmastree;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChristmasTreeTest {

    @Test
    public void shouldReturnProperChristmasTree() {
        //given
        int size = 5;
        List<String> expected = Arrays.asList("     *", "    ***", "   *****", "  *******", " *********", "     **");

        //when
        List<String> result = ChristmasTree.getChristmasTree(size);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnIllegalArgumentException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ChristmasTree.getChristmasTree(-1);
        });

        assertEquals("Number must be greater than 0", thrown.getMessage());
    }
}
