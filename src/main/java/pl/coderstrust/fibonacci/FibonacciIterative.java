package pl.coderstrust.fibonacci;

public class FibonacciIterative {

    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("fibonacciNumberInOrder must be positive");
        }

        if (fibonacciNumberInOrder <= 1) {
            return fibonacciNumberInOrder;
        }

        int[] fib = {0, 1, 1};
        for (int i = 2; i < fibonacciNumberInOrder; i++) {
            fib[0] = fib[1];
            fib[1] = fib[2];
            fib[2] = fib[0] + fib[1];
        }
        return fib[2];
    }
}
