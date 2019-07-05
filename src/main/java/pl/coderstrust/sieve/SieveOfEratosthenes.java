package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {
    private static final int NON_PRIME_MARKER = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieve(131)));
    }

    public static int[] sieve(int maximumNumber) {
        if (maximumNumber < 2) {
            return new int[0];
        }
        int[] array = createInitialArray(maximumNumber);
        int countOfNonPrimeNumbers = markNonePrimeNumbers(array);
        int countOfPrimeNumbers = array.length - countOfNonPrimeNumbers;
        return extractPrimeNumbers(array, countOfPrimeNumbers);
    }

    private static int[] createInitialArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int markNonePrimeNumbers(int[] array) {
        int numberOfNonPrimeNumbers = 2;
        for (int i = 2; (i * i) <= array.length; i++) {
            if (array[i] != NON_PRIME_MARKER) {
                for (int j = i; (i * j) <= array.length - 1; j++) {
                    if (array[i * j] != NON_PRIME_MARKER) {
                        array[i * j] = NON_PRIME_MARKER;
                        numberOfNonPrimeNumbers++;
                    }
                }
            }
        }
        return numberOfNonPrimeNumbers;
    }

    private static int[] extractPrimeNumbers(int[] array, int countOfPrimeNumbers) {
        int[] primeNumbers = new int[countOfPrimeNumbers];
        for (int i = 2, j = 0; i < array.length; i++) {
            if (array[i] != NON_PRIME_MARKER) {
                primeNumbers[j++] = array[i];
            }
        }
        return primeNumbers;
    }
}
