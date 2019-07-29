package pl.coderstrust.myOwnArrayList;

import java.util.Arrays;

public class MyOwnArray implements List<Long> {
    private Object[] myArray;
    private int size = 0;

    public MyOwnArray() {
        myArray = new Object[10];
    }

    public Object getObjectOnIndex(int index) {
        if (index < size) {
            return myArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(Object obj) {
        if (myArray.length - size <= 5) {
            increaseListSize();
        }
        myArray[size++] = obj;
    }

    public Object removeObjectOnIndex(int index) {
        if (index < size) {
            Object obj = myArray[index];
            myArray[index] = null;
            int tmp = index;
            while (tmp < size) {
                myArray[tmp] = myArray[tmp + 1];
                myArray[tmp + 1] = null;
                tmp++;
            }
            size--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

    private void increaseListSize() {
        myArray = Arrays.copyOf(myArray, myArray.length * 2);
        System.out.println("\nNew length: " + myArray.length);
    }

    public static void main(String a[]) {
        MyOwnArray mal = new MyOwnArray();
        mal.add(2);
        mal.add(5);
        mal.add(1);
        mal.add(23);
        mal.add(14);
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.getObjectOnIndex(i) + " ");
        }
        mal.add(29);
        System.out.println("Element at Index 5:" + mal.getObjectOnIndex(5));
        System.out.println("List size: " + mal.size());
        System.out.println("Removing element at index 2: " + mal.removeObjectOnIndex(2));
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.getObjectOnIndex(i) + " ");
        }
    }
}
