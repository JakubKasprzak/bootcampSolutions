package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieve(121)));
    }

    private static int[] sieve(int maximumNumber) {
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
        for (int i = 2; i < size; i++) {

            array[i] = i + 1;
        }
        return array;
    }

    private static int markNonePrimeNumbers(int[] array) {
        int numberOfNonPrimeNumbers = 2;

        for (int j = 2; j <= array.length; j++) {
            if (array[j - 1] != 0) {
                for (int i = j + j; i <= array.length; i += j) {
                    if (array[i - 1] != 0) {
                        array[i - 1] = 0;
                        numberOfNonPrimeNumbers++;
                    }
                }
            }
        }
        return numberOfNonPrimeNumbers;
    }

    private static int[] extractPrimeNumbers(int[] array, int countOfPrimeNumbers) {
        int[] onlyPrimeNumbers = new int[countOfPrimeNumbers];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != 0) {
                onlyPrimeNumbers[j] = array[i];
                j += 1;
            }
        }
        return onlyPrimeNumbers;
    }
}
