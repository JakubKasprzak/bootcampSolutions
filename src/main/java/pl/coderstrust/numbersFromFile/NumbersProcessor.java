package pl.coderstrust.numbersFromFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersProcessor {

    public static void main(String[] args) {
    }

    public String processLine(String line) {
        if (line.matches("[ 0-9]+")) {
            StringBuilder newLine = new StringBuilder();
            Scanner scanner = new Scanner(line);
            List<Integer> numbersList = new ArrayList<>();
            int sum = 0;
            while (scanner.hasNext()) {
                int number = scanner.nextInt();
                numbersList.add(number);
                sum += number;
                if (scanner.hasNext() == false) {
                    newLine.append("=");
                } else if (numbersList.size() == 1) {
                    newLine.append(number);
                } else {
                    newLine.append("+" + number);
                }
            }
            scanner.close();
            newLine.append(sum);
            String result = newLine.toString();
            return result;
        } else {
            return "";
        }
    }
}
