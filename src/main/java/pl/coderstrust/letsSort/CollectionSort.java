package pl.coderstrust.letsSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSort implements SortingMethod {

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

        List<Integer> intList = new ArrayList<>();
        for (int i : array) {
            intList.add(i);
        }
        Collections.sort(intList);
        int[] arraySorted = new int[intList.size()];
        for (int i = 0; i < arraySorted.length; i++) {
            arraySorted[i] = intList.get(i).intValue();
        }
        return arraySorted;
    }

    @Override
    public String name() {
        String name = "CollectionSort";
        return name;
    }
}
