package pl.coderstrust.multithreading;

public class Magazine {

    public static void main(String[] args)
            throws InterruptedException {
        final User user = new User();
        Object element = new Object();

        Thread producer = new Thread(() -> {
            try {
                user.produce(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                user.consume(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
