package pl.coderstrust.christmastree;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {

    public static void main(String[] args) {
        List<String> ChristmasTree = getChristmasTree(3);
        ChristmasTree.forEach(System.out::println);
    }

    public static List<String> getChristmasTree(int size) {
        if (size < 3) {
            throw new IllegalArgumentException("Number must be greater than two.");
        }

        List<String> result = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            line.append(" ");
            for (int j = size - i; j > 0; j--) {
                line.append(" ");
            }
            for (int j = i * 2 - 1; j > 0; j--) {
                line.append("*");
            }
            result.add(line.toString());
            line.setLength(0);
        }
        line.append(" ");
        for (int i = 0; i < size - 1; i++) {
            line.append(" ");
        }
        line.append("**");
        result.add(line.toString());
        return (result);
    }
}
