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
        for (int a = 1; a <= tablesize; a++) {
            System.out.printf("%4d", a);
            for (int b = 1; b <= tablesize; b++) {
                System.out.printf("%4d", a * b);
            }
            System.out.println();
        }
    }
}
