package pl.coderstrust.myownarraylist;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListTest {

    @Test
    public void shouldReturnCorrectArraySize() {
        //given
        List<Object> list = new ArrayList<>();
        //when
        list.add(null);
        //then
        assertEquals(1, list.size());
    }

    @Test
    public void shouldReturnFalseWhenListIsNotEmpty() {
        //given
        List<Object> list = new ArrayList<>();
        //when
        list.add(null);
        //then
        assertFalse(list.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenListContainsGivenElement() {
        //given
        List<Object> list = new ArrayList<>();
        //when
        Object element = "some element";
        list.add(element);
        //then
        assertTrue(list.contains(element));
    }

    @Test
    public void shouldReturnFalseWhenIteratorHasNoNextIndex() {
        List<Object> list = new ArrayList<>();
        assertFalse(list.iterator().hasNext());
    }

    @Test
    public void shouldReturnElementWhenIteratorHasNext() {
        //given
        List<Object> list = new ArrayList<>();
        list.add("some element");
        list.add("another element");
        list.add("yet another element");
        //when
        Iterator iterator = list.iterator();
        int i = 1;
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(i).append(".").append(iterator.next().toString()).append(" ");
            i++;
        }
        String resultLine = "1.some element 2.another element 3.yet another element ";
        //then
        assertEquals(resultLine, sb.toString());
    }

    @Test
    public void shouldReturnCorrectArrayContainingElementsFromList() {
        //given
        List<Object> list = new ArrayList<>();
        Object element = "some element";
        list.add(element);
        //when
        Object[] expectedArray = new Object[list.size()];
        expectedArray[0] = element;
        //then
        assertArrayEquals(expectedArray, list.toArray());
    }

    @Test
    public void shouldAddNewElementToList() {
        //given
        List<Object> list = new ArrayList<>();
        //when
        list.add("some element");
        //then
        assertSame("some element", list.get(list.size() - 1));
    }

    @Test
    public void shouldRemoveIndicatedElementFromList() {
        //given
        List<Object> list = new ArrayList<>();
        Object element = "some element";
        //when
        list.add(element);
        list.remove(element);
        //then
        assertFalse(list.contains(element));
    }

    @Test
    public void shouldAddAllCollectionToList() {
        //given
        List<Object> list = new ArrayList<>();
        list.add("Some element on list.");
        List<Object> listToAdd = new ArrayList<>();
        listToAdd.add("Some element od list to add.");
        listToAdd.add("Another element od list to add.");
        //when
        list.addAll(listToAdd);
        Iterator iterator = list.iterator();
        int i = 1;
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(i).append(".").append(iterator.next().toString()).append(" ");
            i++;
        }
        String resultLine = "1.Some element on list. 2.Some element od list to add. 3.Another element od list to add. ";
        //then
        assertEquals(resultLine, sb.toString());
    }

    @Test
    public void shouldRemoveAllElements() {
        //given
        List<Object> list = new ArrayList<>();
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
        List<Object> list = new ArrayList<>();
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
        List<Object> list = new ArrayList<>();
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
        List<Object> list = new ArrayList<>();
        Object element = "some element";
        Object newElement = "new element";
        //when
        list.add(element);
        list.add(0, newElement);
        //then
        assertSame("new element", list.get(0));
    }

    @Test
    public void shouldRemoveElementFromFromGivenIndex() {
        //given
        List<Object> list = new ArrayList<>();
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
        List<Object> list = new ArrayList<>();
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
        List<Object> list = new ArrayList<>();
        Object element = "some element";
        Object anotherElement = "another element";
        //when
        list.add(element);
        list.add(anotherElement);
        list.add(element);
        //then
        assertEquals(2, list.lastIndexOf(element));
    }
}
