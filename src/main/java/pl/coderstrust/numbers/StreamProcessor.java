package pl.coderstrust.numbers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class StreamProcessor {

    public void process(String inputFilePath, String resultFilePath) throws IOException {
        if (inputFilePath == null) {
            throw new IllegalArgumentException("Input file path cannot be null.");
        }
        if (resultFilePath == null) {
            throw new IllegalArgumentException("Result file path cannot be null.");
        }
        Path inputPath = Paths.get(inputFilePath);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(resultFilePath))) {
            Files.lines(inputPath)
                    .filter(line -> line.matches("^[\\d\\s]+$"))
                    .map(line -> line.trim().split("\\s+"))
                    .map(StreamProcessor::convert)
                    .forEach(printWriter::println);
        }
    }

    private static String convert(String[] array) {
        int sum = Arrays.stream(array).mapToInt(Integer::valueOf).sum();
        return Arrays.stream(array)
                .reduce((num1, num2) -> String.format("%s+%s", num1, num2))
                .get()
                .concat("=")
                .concat(Integer.toString(sum));
    }
}
