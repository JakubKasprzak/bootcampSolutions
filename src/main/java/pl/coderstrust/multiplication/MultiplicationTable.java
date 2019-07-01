package pl.coderstrust.multiplication;

import java.util.Arrays;

public class MultiplicationTable {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getMultiplicationTable(4)));
    }

    public static int[][] getMultiplicationTable(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }

        int[][] table = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }
}
