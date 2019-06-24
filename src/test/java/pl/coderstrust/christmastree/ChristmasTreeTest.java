package pl.coderstrust.christmastree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ChristmasTreeTest {

    @Test
    public void shouldReturnProperChristmasTree() {
//given
        int size = 5;
        List<String> expected = Arrays.asList("     *", "    ***", "   *****", "  *******", " *********", "     **");

        //when
        List<String> result = ChristmasTree.getChristmasTree(size);

        //then
        assertArrayEquals(expected,result);
    }
}