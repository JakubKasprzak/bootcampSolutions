package pl.coderstrust.multithreading;

import java.util.LinkedList;
import java.util.List;

class User {
   private List<Object> list = new LinkedList<>();
    private final int CAPACITY = 10;

    void produce(Object element) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == CAPCITY)
                    wait();
                list.add(element);
                System.out.println("Producer produced, actual quantity is "
                        + list.size());
                notify();
                Thread.sleep(1000);
            }
        }
    }

    void consume(Object element) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0)
                    wait();
                list.remove(element);
                System.out.println("Consumer consumed, actual quantity is "
                        + list.size());
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
