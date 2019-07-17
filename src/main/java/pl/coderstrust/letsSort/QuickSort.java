package pl.coderstrust.letsSort;

public class QuickSort implements SortingMethod {

    public static void main(String args[]) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
    }

    @Override
    public int[] sort(int[] array) {
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
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }

    @Override
    public String name() {
        String name = "QuickSort";
        return name;
    }
}
