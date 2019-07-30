package pl.coderstrust.myOwnArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class MyOwnArray<T> implements List<T> {
    private Object[] objects = {};
    private int size = 0;
    private final static int DEFAULT_SIZE = 10;
    private int totalArraySize = DEFAULT_SIZE;

    public MyOwnArray() {
        objects = new Object[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(objects, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        resize();
        objects[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object t) {
        int index = indexOf(t);
        if (index >= 0) {
            System.arraycopy(objects, index + 1, objects, index, size - index - 1);
            size--;
            objects[size] = null;
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
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
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
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < size && index >= 0) {
            return (T) objects[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T set(int index, T setObject) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object oldObject = objects[index];
        objects[index] = setObject;
        return (T) oldObject;
    }

    @Override
    public void add(int index, T addObject) {
        resize();
        System.arraycopy(objects, index, objects, index + 1, size - index);
        objects[index] = addObject;
        ++size;
    }

    @Override
    public T remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(objects, index + 1, objects, index, size - index - 1);
        objects[--size] = null;
        resize();
        return null;
    }

    @Override
    public int indexOf(Object t) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object t) {
        if (t == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (objects[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (t.equals(objects[i])) {
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
        if (size >= totalArraySize) {
            Object[] newValues = new Object[size * 2];
            System.arraycopy(objects, 0, newValues, 0, size);
            objects = newValues;
        }
        if (size >= DEFAULT_SIZE && size < totalArraySize / 4) {
            Object[] newValues = new Object[size / 2];
            System.arraycopy(objects, 0, newValues, 0, size);
            objects = newValues;
        }
    }
}
