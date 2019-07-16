package pl.coderstrust.isthatfibonacci;

import java.util.HashSet;
import java.util.Set;

public class IsThatFibonacciNumberCache {
    static Set<Long> fibonacciNumbers = new HashSet<>();

    static {
        fillFibonacciSet();
    }

    public static void main(String args[]) {
        int number = 102334156;
        System.out.println(number + " is " + (checkNumber(number) ? "truly" : "not") + " a Fibonacci number");
    }

    public static boolean checkNumber(long number) {
        if (number < 1) {
            return false;
        }
        return fibonacciNumbers.contains(number);
    }

    private static void fillFibonacciSet() {
        long[] fib = {0, 1, 1};
        fibonacciNumbers.add(fib[1]);
        while (fib[1] < Long.MAX_VALUE / 2) {
            fib[0] = fib[1];
            fib[1] = fib[2];
            fib[2] = fib[0] + fib[1];
            fibonacciNumbers.add(fib[2]);
        }
    }
}
