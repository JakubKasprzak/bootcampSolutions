package pl.coderstrust.fibonacci;

public class FibonacciRecursive {

    public static void main(String[] args) {
        System.out.println(fibonacci(11));
    }

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("fibonacciNumberInOrder must be positive");
        }

        return fibonacciRecursive(fibonacciNumberInOrder);
    }

    private static long fibonacciRecursive(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder <= 1) {
            return fibonacciNumberInOrder;
        }

        return fibonacciRecursive(fibonacciNumberInOrder - 2) + fibonacciRecursive(fibonacciNumberInOrder - 1);
    }
}
