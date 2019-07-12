package pl.coderstrust.hoarePartition;

import java.util.Arrays;

public class HoarePartition {

    public static void main(String[] args) {
        int numbers[] = {25, 14, 48, 33, 72, 8, 99};
        sort(numbers);
        System.out.println("Sorted array is: " + Arrays.toString(numbers));
    }

    public static int sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        int pivotIndex = countPivotIndex(array);
        int pivot = array[pivotIndex];
        System.out.println("Pivot is: " + pivot);
        swap(array, pivotIndex, 0);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            do {
                i++;
            } while (array[i] < pivot && i < j);
            do {
                j--;
            } while (array[j] > pivot);
            if (i < j) {
                swap(array, i, j);
            }
        }
        return bringBackPivot(array, pivot);
    }

    private static int countPivotIndex(int[] array) {
        return array.length / 2;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public static int bringBackPivot(int[] array, int pivot) {
        int pivotIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (pivot > array[i]) {
                swap(array, pivotIndex, i);
                pivotIndex = i;
            }
        }
        int newPivotIndex = pivotIndex;
        return newPivotIndex;
    }
}
