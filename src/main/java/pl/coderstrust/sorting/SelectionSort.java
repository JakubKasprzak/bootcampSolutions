package pl.coderstrust.sorting;

public class SelectionSort implements SortingMethod {
    private static final String NAME = "SelectionSort";

    public static void main(String args[]) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        SelectionSort selectionsort = new SelectionSort();
        selectionsort.sort(array);
    }

    @Override
    public int[] sort(int[] array) {
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
