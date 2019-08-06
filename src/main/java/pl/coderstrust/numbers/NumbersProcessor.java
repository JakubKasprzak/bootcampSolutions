package pl.coderstrust.numbers;

import java.util.Scanner;

public class NumbersProcessor {

    public String processLine(String line) {
        if (!isLineValid(line)) {
            return "";
        }
        StringBuilder resultLine = new StringBuilder();
        int sum = 0;
        try (Scanner scanner = new Scanner(line)) {
            int number = 0;
            while (scanner.hasNextInt()) {
                number = scanner.nextInt();
                sum += number;
                resultLine.append(number);
                if (scanner.hasNextInt()) {
                    resultLine.append("+");
                } else {
                    resultLine.append("=");
                }
            }
        }
        return resultLine.append(sum).toString();
    }

    private static boolean isLineValid(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        return line.matches("^[\\d\\s]+");
    }
}
