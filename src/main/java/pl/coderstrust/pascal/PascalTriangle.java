package pl.coderstrust.pascal;

public class PascalTriangle {

    public static void main(String[] args) {
        int treesize = 12;
        printPascalTriangle(treesize);
    }

    public static void printPascalTriangle(int size) {
        for (int n = 0; n <= size; n++) {
            for (int i = size - n; i > 0; i--) {
                System.out.printf("%2s", "");
            }
            for (int k = 0; k <= n; k++) {
                System.out.printf("%4d", binomialCoefficient(n, k));
            }
            System.out.println();
        }
    }

    private static int binomialCoefficient(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    private static int factorial(int n) {
        int factn = 1;
        for (int a = 2; a <= n; a++) {
            factn = factn * a;
        }
        return factn;
    }
}
