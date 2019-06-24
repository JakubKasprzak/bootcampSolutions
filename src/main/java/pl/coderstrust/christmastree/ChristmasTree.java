package pl.coderstrust.christmastree;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {

    public static void main(String[] args) {
        List<String> ChristmasTree = getChristmasTree(5);
         ChristmasTree.forEach(System.out::println);
    }

    public static List<String> getChristmasTree(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }

        List<String> result = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= size; i++) {
//            System.out.println();
            line.append(" ");
            for (int j = size - i; j > 0; j--) {
//                System.out.print(" ");
                line.append(" ");
            }
            for (int j = i * 2 - 1; j > 0; j--) {
//                System.out.print("*");
                line.append("*");
            }
            result.add(line.toString());
            line.setLength(0);
        }
//        System.out.println();
        line.append(" ");
        for (int i = 0; i < size - 1; i++) {
//            System.out.print(" ");
            line.append(" ");
        }
//        System.out.println("**");
        line.append("**");
        result.add(line.toString());
        return(result);
    }
}
