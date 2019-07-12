package pl.coderstrust.letsSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SortingTestBase {
    public abstract SortingMethod getSortingMethod();

    @Test
    public void shouldSortSimpleArray(){
        // given
        int[] given = new int[]{5, 4, 3, 2, 1};
        int[] expected = new int[]{1, 2, 3, 4, 5};

        // when
        long startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(given);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

        // then
        assertArrayEquals(expected, result);
    }

//  ....

}
