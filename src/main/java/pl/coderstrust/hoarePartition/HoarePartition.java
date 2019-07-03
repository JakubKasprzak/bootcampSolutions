package pl.coderstrust.hoarePartition;

import java.util.Arrays;

public class HoarePartition {

    public static void main(String[] args) {
        int numbers[] = {64, 34, 12, 25, 22, 11, 90};
        System.out.println(Arrays.toString(divide(numbers)));
    }

    private static int[] divide(int[] array) {
        int first = 0;
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int[] dividedArray = array.clone();
        int pivotIndex = countPivotIndex(dividedArray);
        int pivot = dividedArray[pivotIndex];
        swap(dividedArray, pivotIndex, first);
        for (int i = 1; i <= dividedArray.length; i++) {
            for (int j = dividedArray.length - 1; j > i; j--) {
                if (dividedArray[i] > pivot && dividedArray[j] < pivot) {
                    swap(dividedArray, i, j);
                }
            }
        }
        bringBackPivot(dividedArray, pivot);
        return dividedArray;
    }

    private static int countPivotIndex(int[] array) {
        if (array.length % 2 == 0) {
            return array.length / 2;
        } else {
            return (array.length - 1) / 2;
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    private static int[] bringBackPivot(int[] array, int pivot) {
        int pivotIndex = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (pivot > array[i]) {
                swap(array, pivotIndex, i);
                pivotIndex = i;
            }
        }
        return array;
    }
}
