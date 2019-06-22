package pl.coderstrust.christmastree;

public class ChristmasTree {

    public static void main(String[] args) {
        printChristmasTree(5);
    }

    public static void printChristmasTree(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("treesize must be greater than zero");
        }

        for (int i = 1; i <= size; i++) {
            System.out.println();
            for (int j = size - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = i * 2 - 1; j > 0; j--) {
                System.out.print("*");
            }
        }
        System.out.println();
        for (int i = 0; i < size - 1; i++) {
            System.out.print(" ");
        }
        System.out.println("**");
    }
}
