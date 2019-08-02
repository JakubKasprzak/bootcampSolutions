package pl.coderstrust.myOwnArrayList;

import java.util.*;

class MyOwnArray<T> implements List<T> {
    private Object[] list;
    private int sizeWithElements = 0;
    private final static int DEFAULT_SIZE = 10;

    public MyOwnArray() {
        list = new Object[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return sizeWithElements;
    }

    @Override
    public boolean isEmpty() {
        return sizeWithElements == 0;
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
                return nextToRetIndex != sizeWithElements;
            }

            @Override
            public T next() {
                int i = nextToRetIndex;
                if (i >= sizeWithElements) {
                    throw new NoSuchElementException();
                }
                if (i >= list.length) {
                    throw new ConcurrentModificationException();
                }
                nextToRetIndex = i + 1;
                return (T) list[lastRet = i];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[sizeWithElements];
        System.arraycopy(list, 0, newArray, 0, sizeWithElements);
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        resize();
        list[sizeWithElements++] = t;
        return true;
    }

    @Override
    public boolean remove(Object t) {
        int index = indexOf(t);
        if (index >= 0) {
            System.arraycopy(list, index + 1, list, index, sizeWithElements - index - 1);
            sizeWithElements--;
            list[sizeWithElements] = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] addedCollection = c.toArray();
        int sizeOfaddedCollection = addedCollection.length;
        if (sizeOfaddedCollection == 0) {
            return false;
        }
        Object[] oldList = list;
        if (sizeOfaddedCollection > list.length - sizeWithElements) {
            list = Arrays.copyOf(oldList, sizeWithElements + sizeOfaddedCollection);
        }
        System.arraycopy(addedCollection, 0, oldList, sizeWithElements, sizeOfaddedCollection);
        sizeWithElements = sizeWithElements + sizeOfaddedCollection;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < sizeWithElements; i++) {
            list[i] = null;
        }
        sizeWithElements = 0;
    }

    @Override
    public T get(int index) {
        if (index < sizeWithElements && index >= 0) {
            return (T) list[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T set(int index, T setObject) {
        if (index >= sizeWithElements) {
            throw new IndexOutOfBoundsException();
        }
        T oldObject = (T) list[index];
        list[index] = setObject;
        return (T) oldObject;
    }

    @Override
    public void add(int index, T addObject) {
        resize();
        System.arraycopy(list, index, list, index + 1, sizeWithElements - index);
        list[index] = addObject;
        ++sizeWithElements;
    }

    @Override
    public T remove(int index) {
        if (index > sizeWithElements) {
            throw new IndexOutOfBoundsException();
        }
        T oldObject = (T) list[index];
        System.arraycopy(list, index + 1, list, index, sizeWithElements - index - 1);
        list[--sizeWithElements] = null;
        resize();
        return oldObject;
    }

    @Override
    public int indexOf(Object t) {
        for (int i = 0; i < sizeWithElements; i++) {
            if (list[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object t) {
        if (t == null) {
            for (int i = sizeWithElements - 1; i >= 0; i--) {
                if (list[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = sizeWithElements - 1; i >= 0; i--) {
                if (t.equals(list[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void resize() {
        if (sizeWithElements >= list.length) {
            Object[] newObjects = new Object[sizeWithElements * 2];
            System.arraycopy(list, 0, newObjects, 0, sizeWithElements);
            list = newObjects;
        }
        if (sizeWithElements >= DEFAULT_SIZE && sizeWithElements < list.length / 4) {
            Object[] newObjects = new Object[sizeWithElements / 2];
            System.arraycopy(list, 0, newObjects, 0, sizeWithElements);
            list = newObjects;
        }
    }
}
