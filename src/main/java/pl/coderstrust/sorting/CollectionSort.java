package pl.coderstrust.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionSort implements SortingMethod {
    private static final String NAME = "CollectionSort";

    public static void main(String args[]) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        CollectionSort collectionSort = new CollectionSort();
        collectionSort.sort(numbers);
    }

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        List<Integer> intList = Arrays.stream(array).boxed().collect(Collectors.toList());
        Collections.sort(intList);
        return intList.stream().mapToInt(Integer::intValue).toArray();
    }
}
