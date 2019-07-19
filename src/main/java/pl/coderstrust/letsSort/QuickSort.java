package pl.coderstrust.letsSort;

import java.util.Arrays;

public class QuickSort implements SortingMethod {
    private static final String NAME = "QuickSort";

    public static void main(String args[]) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        System.out.println(Arrays.toString(quickSort.sort(numbers)));
    }

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int begin = 0;
        int end = array.length - 1;
        int[] sortedArray = array.clone();
        quickSort(sortedArray, begin, end);
        return sortedArray;
    }

    private void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    @Override
    public String name() {
        return NAME;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
