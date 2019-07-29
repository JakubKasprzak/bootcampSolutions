package pl.coderstrust.numbers;

import java.util.Scanner;

public class NumbersProcessor {

    public String processLine(String line) {
        if (isLineValid(line)) {
            StringBuilder newLine = new StringBuilder();
            try (Scanner scanner = new Scanner(line)) {
                int sum = 0;
                while (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    if (sum == 0) {
                        newLine.append(number);
                        sum += number;
                    } else if (!scanner.hasNext()) {
                        sum += number;
                        newLine.append("+").append(number).append("=").append(sum);
                    } else {
                        sum += number;
                        newLine.append("+").append(number);
                    }
                }
            }
            return newLine.toString();
        }
        return "";
    }

    private static boolean isLineValid(String line) {
        if (line.matches("(\\D*\\d+\\D*)+")) {
            return true;
        }
        return false;
    }
}
