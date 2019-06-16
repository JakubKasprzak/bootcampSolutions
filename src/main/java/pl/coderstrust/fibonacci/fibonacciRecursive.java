package pl.coderstrust.fibonacci;

public class fibonacciRecursive {

    public static void main(String[] args) {
        System.out.println(fibonacci(11));
    }

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("fibonacciNumberInOrder must be positive");
        }

        return fibonacciRec(fibonacciNumberInOrder);
    }

    private static long fibonacciRec(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder <= 1) {
            return fibonacciNumberInOrder;
        }

        return fibonacciRec(fibonacciNumberInOrder - 2) + fibonacciRec(fibonacciNumberInOrder - 1);
    }
}
