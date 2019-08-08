package pl.coderstrust.myownarraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class ArrayList<T> implements List<T> {
    private Object[] values;
    private int numberOfElements = 0;
    private final static int CAPACITY = 10;

    public ArrayList() {
        values = new Object[CAPACITY];
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int nextToRetIndex;       // index of next element to return
            int lastRet = -1; // index of last element returned; -1 if no such

            @Override
            public boolean hasNext() {
                return nextToRetIndex != numberOfElements;
            }

            @Override
            public T next() {
                int i = nextToRetIndex;
                if (i >= numberOfElements) {
                    throw new NoSuchElementException();
                }
                if (i >= values.length) {
                    throw new ConcurrentModificationException();
                }
                nextToRetIndex = i + 1;
                return (T) values[lastRet = i];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[numberOfElements];
        System.arraycopy(values, 0, newArray, 0, numberOfElements);
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Unsupported operation for this array list.");
    }

    @Override
    public boolean add(T t) {
        resize();
        values[numberOfElements++] = t;
        return true;
    }

    @Override
    public boolean remove(Object t) {
        int index = indexOf(t);
        if (index >= 0) {
            System.arraycopy(values, index + 1, values, index, numberOfElements - index - 1);
            numberOfElements--;
            values[numberOfElements] = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported operation for this array list.");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        resize();
        Object[] addedCollection = c.toArray();
        int sizeOfAddedCollection = addedCollection.length;
        if (sizeOfAddedCollection == 0) {
            return false;
        }
        Object[] oldList = values;
        if (sizeOfAddedCollection > values.length - numberOfElements) {
            values = Arrays.copyOf(oldList, numberOfElements + sizeOfAddedCollection);
        }
        System.arraycopy(addedCollection, 0, oldList, numberOfElements, sizeOfAddedCollection);
        numberOfElements = numberOfElements + sizeOfAddedCollection;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Unsupported operation for this array list.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported operation for this array list.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported operation for this array list.");
    }

    @Override
    public void clear() {
        for (int i = 0; i < numberOfElements; i++) {
            values[i] = null;
        }
        numberOfElements = 0;
    }

    @Override
    public T get(int index) {
        if (!isIndexInRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        return (T) values[index];
    }

    private boolean isIndexInRange(int index) {
        return index < numberOfElements && index >= 0;
    }

    @Override
    public T set(int index, T setObject) {
        if (index >= numberOfElements) {
            throw new IndexOutOfBoundsException();
        }
        T oldObject = (T) values[index];
        values[index] = setObject;
        return (T) oldObject;
    }

    @Override
    public void add(int index, T addObject) {
        resize();
        System.arraycopy(values, index, values, index + 1, numberOfElements - index);
        values[index] = addObject;
        ++numberOfElements;
    }

    @Override
    public T remove(int index) {
        resize();
        if (index > numberOfElements) {
            throw new IndexOutOfBoundsException();
        }
        T oldObject = (T) values[index];
        System.arraycopy(values, index + 1, values, index, numberOfElements - index - 1);
        values[--numberOfElements] = null;
        resize();
        return oldObject;
    }

    @Override
    public int indexOf(Object t) {
        for (int i = 0; i < numberOfElements; i++) {
            if (values[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object t) {
        if (t == null) {
            for (int i = numberOfElements - 1; i >= 0; i--) {
                if (values[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = numberOfElements - 1; i >= 0; i--) {
                if (t.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Unsupported operation for this array list.");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Unsupported operation for this array list.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Unsupported operation for this array list.");
    }

    private void resize() {
        if (numberOfElements == values.length) {
            Object[] newObjects = new Object[numberOfElements * 2];
            System.arraycopy(values, 0, newObjects, 0, numberOfElements);
            values = newObjects;
        }
        if (numberOfElements >= CAPACITY && numberOfElements < values.length / 4) {
            Object[] newObjects = new Object[numberOfElements / 2];
            System.arraycopy(values, 0, newObjects, 0, numberOfElements);
            values = newObjects;
        }
    }
}
