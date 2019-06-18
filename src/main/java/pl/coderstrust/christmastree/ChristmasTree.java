package pl.coderstrust.christmastree;

public class ChristmasTree {

    public static void main(String[] args) {
        printTree(10);
    }

    public static void printTree(int treesize) {
        if (treesize < 0) {
            return;
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
        for (int l = (2 * treesize - 1) / 2 - 1; l > 0; l--) {
            System.out.print(" ");
        }
        System.out.println("**");
    }
}
