package pl.coderstrust.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int numbers[] = {64, 34, 25, 12, 22, 11, 90};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static int[] sort(int[] array) {
        int n = array.length;
        if (n == 0 ) {
            throw new IllegalArgumentException("array must be filled with at least one number");
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
