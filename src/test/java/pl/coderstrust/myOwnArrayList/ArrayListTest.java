package pl.coderstrust.myOwnArrayList;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void shouldReturnCorrectArraySize() {
        //given
        List<Object> list = new MyOwnArray<>();
        //when
        list.add(null);
        //then
        assertEquals(1, list.size());
    }

    @Test
    public void shouldReturnFalseWhenListIsNotEmpty() {
        //given
        List<Object> list = new MyOwnArray<>();
        //when
        list.add(null);
        //then
        assertFalse(list.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenListContainsGivenElement() {
        //given
        List<Object> list = new MyOwnArray<>();
        //when
        Object element = "some element";
        list.add(element);
        //then
        assertTrue(list.contains(element));
    }

    @Test
    public void shouldReturnCorrectArrayContainingElementsFromList() {
        //given
        List<Object> list = new MyOwnArray<>();
        Object element = "some element";
        list.add(element);
        //when
        Object[] expectedArray = new Object[list.size()];
        expectedArray[0] = element;
        //then
        assertTrue(Arrays.equals(expectedArray, list.toArray()));
    }

    @Test
    public void shouldAddNewElementToList() {
        //given
        List<Object> list = new MyOwnArray<>();
        //when
        list.add("some element");
        //then
        assertTrue(list.get(list.size() - 1) == "some element");
    }

    @Test
    public void shouldRemoveIndicatedElementFromList() {
        //given
        List<Object> list = new MyOwnArray<>();
        Object element = "some element";
        //when
        list.add(element);
        list.remove(element);
        //then
        assertFalse(list.contains(element));
    }

    @Test
    public void shouldRemoveAllElements() {
        //given
        List<Object> list = new MyOwnArray<>();
        Object element = "some element";
        //when
        list.add(element);
        list.clear();
        int size = list.size();
        //then
        assertEquals(0, size);
    }

    @Test
    public void shouldReturnCorrectElementFromGivenIndex() {
        //given
        List<Object> list = new MyOwnArray<>();
        //when
        list.add("some element");
        list.add("another element");
        //then
        assertEquals("some element", list.get(0));
        assertEquals("another element", list.get(1));
    }

    @Test
    public void shouldReplaceElementOnGivenIndex() {
        //given
        List<Object> list = new MyOwnArray<>();
        Object oldElement = "old element";
        Object newElement = "new element";
        //when
        list.add(oldElement);
        //then
        assertEquals(oldElement, list.set(0, newElement));
    }

    @Test
    public void shouldAddElementOnGivenIndex() {
        //given
        List<Object> list = new MyOwnArray<>();
        Object element = "some element";
        Object newElement = "new element";
        //when
        list.add(element);
        list.add(0, newElement);
        //then
        assertTrue(list.get(0) == "new element");
    }

    @Test
    public void shouldRemoveElementFromFromGivenIndex() {
        //given
        List<Object> list = new MyOwnArray<>();
        Object element = "some element";
        Object anotheElement = "another element";
        Object yetAnotheElement = "yet another element";
        //when
        list.add(element);
        list.add(anotheElement);
        list.add(yetAnotheElement);
        list.remove(1);
        //then
        assertFalse(list.contains(anotheElement));
    }

    @Test
    public void shouldReturnCorrectIndexOfGivenElement() {
        //given
        List<Object> list = new MyOwnArray<>();
        Object element = "some element";
        Object anotheElement = "another element";
        Object yetAnotheElement = "yet another element";
        //when
        list.add(element);
        list.add(anotheElement);
        list.add(yetAnotheElement);
        //then
        assertEquals(1, list.indexOf(anotheElement));
    }

    @Test
    public void shouldReturnLastIndexOfGivenElement() {
        //given
        List<Object> list = new MyOwnArray<>();
        System.out.println(list.getA);
        Object element = "some element";
        Object anotheElement = "another element";
        Object yetAnotheElement = "yet another element";
        //when
        list.add(element);
        list.add(anotheElement);
        list.add(yetAnotheElement);
        //then
        assertEquals(1, list.lastIndexOf(anotheElement));
    }
}
