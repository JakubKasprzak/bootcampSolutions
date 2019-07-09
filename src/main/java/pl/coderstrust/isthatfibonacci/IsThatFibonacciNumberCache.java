package pl.coderstrust.isthatfibonacci;

import java.util.HashSet;
import java.util.Set;

public class IsThatFibonacciNumberCache {
    static Set<Long> fibonacciNumbers = new HashSet<>();

    public static void main(String args[]) {
        int number = 102334155;
        if (checkNumber(number)) {
            System.out.println(number + " is truly a Fibonacci number");
        } else {
            System.out.println(number + " is NOT a Fibonacci number");
        }
    }

    public static boolean checkNumber(long number) {
        if (number < 1) {
            return false;
        } else
            fillFibonacciSet();
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
