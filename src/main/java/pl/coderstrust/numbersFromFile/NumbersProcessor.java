package pl.coderstrust.numbersFromFile;

public class NumbersProcessor {

    public static void main(String[] args) {
    }

    static public String processLine(String line) {
        StringBuilder newLine = new StringBuilder();
        String[] stringNumbers = line.split(" +");
        int[] numbers = new int[stringNumbers.length];
        int sum = 0;
        for (int i = 1; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
            sum += numbers[i];
            if (i == stringNumbers.length - 1) {
                newLine.append(numbers[i]);
            } else newLine.append(numbers[i] + "+");
        }
        newLine.append("=" + sum);
        String result = newLine.toString();
        return result;
    }
}
