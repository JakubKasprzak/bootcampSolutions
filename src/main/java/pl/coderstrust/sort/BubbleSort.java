package pl.coderstrust.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int numbers[] = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void bubbleSort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.println(Arrays.toString(numbers));
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = temp;
    }
}
