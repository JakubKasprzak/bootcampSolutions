package pl.coderstrust.sorting;

public class SelectionSortTest extends SortingTestBase {
    @Override
    public SortingMethod getSortingMethod() {
        return new SelectionSort();
    }
}
