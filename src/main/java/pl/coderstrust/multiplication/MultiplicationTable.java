package pl.coderstrust.multiplication;

import java.util.Arrays;

public class MultiplicationTable {

    public static void main(String[] args) {
//        getMultiplicationTable(3);
        System.out.println(Arrays.deepToString(getMultiplicationTable(4)));
    }

    //    public static void getMultiplicationTable(int tablesize) {
//        System.out.printf("%4s", "");
//        for (int i = 1; i <= tablesize; i++) {
//            System.out.printf("%4d", i);
//        }
//        System.out.println();
//        for (int i = 1; i <= tablesize; i++) {
//            System.out.printf("%4d", i);
//            for (int j = 1; j <= tablesize; j++) {
//                System.out.printf("%4d", i * j);
//            }
//            System.out.println();
//        }
//    }
//}
    public static int[][] getMultiplicationTable(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }
}
