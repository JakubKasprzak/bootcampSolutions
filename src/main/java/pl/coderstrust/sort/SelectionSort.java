package pl.coderstrust.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int numbers[] = {64, 34, 25, 12, 22, 11, 90};
        System.out.println(Arrays.toString(sort(numbers)));
    }

    public static int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int i = 0; i < array.length - 1; i++) {
            int minimalValueIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimalValueIndex]) {
                    minimalValueIndex = j;
                }
            }
            swap(array, minimalValueIndex, i);
        }
        return array;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
