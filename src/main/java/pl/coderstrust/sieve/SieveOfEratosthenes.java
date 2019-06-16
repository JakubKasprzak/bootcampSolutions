package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        int[] allNumbers = sieve(12);
        int numberOfZeros = countZeros(allNumbers);
        System.out.println(Arrays.toString(filteredPrimes(allNumbers, allNumbers.length - numberOfZeros)));
    }

    private static int[] sieve(int maximumNumber) {
        int[] allNumbers = new int[maximumNumber];
        for (int i = 0; i < maximumNumber; i++) {
            allNumbers[i] = i + 1;
        }
        return allNumbers;
    }

    private static int countZeros(int[] allNumbers) {
        allNumbers[0] = 0;
        int numberOfZeros = 1;

        for (int j = 2; j * j <= allNumbers.length; j++) {
            if (allNumbers[j - 1] != 0) {
                for (int i = j + j; i <= allNumbers.length; i += j) {
                    if (allNumbers[i - 1] != 0) {
                        allNumbers[i - 1] = 0;
                        numberOfZeros++;
                    }
                }
            }
        }
        return numberOfZeros;
    }

    private static int[] filteredPrimes(int[] filteredNumbers, int n) {
        int[] onlyPrimes = new int[n];
        for (int i = 0, j = 0; i < filteredNumbers.length; i++) {
            if (filteredNumbers[i] != 0) {
                onlyPrimes[j] = filteredNumbers[i];
                j += 1;
            }
        }
        return onlyPrimes;
    }
}
