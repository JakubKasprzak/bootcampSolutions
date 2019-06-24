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

        int[] sortedArray = array.clone();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            int minimalValueIndex = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < sortedArray[minimalValueIndex]) {
                    minimalValueIndex = j;
                }
            }
            swap(sortedArray, minimalValueIndex, i);
        }
        return sortedArray;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
