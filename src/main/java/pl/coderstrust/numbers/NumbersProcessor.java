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
                if (sum == 0) {
                    sum += number;
                    resultLine.append(number);
                } else if (!scanner.hasNext()) {
                    sum += number;
                    resultLine.append("+").append(number).append("=");
                } else {
                    sum += number;
                    resultLine.append("+").append(number);
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
