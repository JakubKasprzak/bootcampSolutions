package pl.coderstrust.christmastree;

public class ChristmasTree {

    public static void main(String[] args) {
        printTree(-1);
    }

    public static void printTree(int treesize) {
        if (treesize < 0) {
            throw new IllegalArgumentException("treesize must be greater than zero");
        }

        for (int i = 1; i <= treesize; i++) {
            System.out.println();
            for (int j = treesize - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = i * 2 - 1; k > 0; k--) {
                System.out.print("*");
            }
        }
        System.out.println();
        for (int i = 0; i < treesize - 1; i++) {
            System.out.print(" ");
        }
        System.out.println("**");
    }
}
