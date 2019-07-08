package pl.coderstrust.pascal;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        List<String> PascalTriangle = getPascalTriangle(9);
        PascalTriangle.forEach(System.out::println);
    }

    public static List<String> getPascalTriangle(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Number must be greater than 0.");
        }

        List<String> result = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (int n = 0; n <= size; n++) {
            for (int i = size - n; i > 0; i--) {
                line.append(String.format("%2s", ""));
            }
            for (int k = 0; k <= n; k++) {
                line.append(String.format("%4d", binomialCoefficient(n, k)));
            }
            result.add(line.toString());
            line.setLength(0);
        }
        return (result);
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
