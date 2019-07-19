package pl.coderstrust.letsSort;

public class MergeSort implements SortingMethod {
    private static final String NAME = "MergeSort";

    public static void main(String args[]) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(numbers);
    }

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int n = array.length;
        int[] sortedArray = array.clone();
        mergeSort(sortedArray, n);
        return sortedArray;
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    private static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    @Override
    public String name() {
        return NAME;
    }
}
