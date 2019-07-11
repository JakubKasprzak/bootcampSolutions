package pl.coderstrust.letsSort;

public class BubbleSort implements SortingMethod {

    public static void main(String args[]) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort bubblesort = new BubbleSort();
        bubblesort.sort(array);
    }


    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int[] sortedArray = array.clone();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    swap(sortedArray, j, j + 1);
                }
            }
        }
        return sortedArray;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
