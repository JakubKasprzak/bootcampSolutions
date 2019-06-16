package pl.coderstrust.multiplication;

public class MultiplicationTable {

    public static void main(String[] args) {
        printMultiplicationTable(7);
    }

    public static void printMultiplicationTable(int tablesize) {
        System.out.printf("%4s", "");
        for (int i = 1; i <= tablesize; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        for (int i = 1; i <= tablesize; i++) {
            System.out.printf("%4d", i);
            for (int j = 1; j <= tablesize; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
