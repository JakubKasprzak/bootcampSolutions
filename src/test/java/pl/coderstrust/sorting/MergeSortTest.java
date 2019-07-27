package pl.coderstrust.sorting;

public class MergeSortTest extends SortingTestBase {
    @Override
    public SortingMethod getSortingMethod() {
        return new MergeSort();
    }
}
