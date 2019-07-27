package pl.coderstrust.sorting;

public class QuickSortTest extends SortingTestBase {
    @Override
    public SortingMethod getSortingMethod() {
        return new QuickSort();
    }
}
