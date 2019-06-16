package pl.coderstrust.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int numbers[] = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void selectionSort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            System.out.println(Arrays.toString(numbers));
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            swap(numbers, min, i);
        }
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[b];
        numbers[b] = numbers[a];
        numbers[a] = temp;
    }
}
