package pl.coderstrust.doyoulovestreams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Processor {

    public void process(String inputFilePath, String resultFilePath) throws IOException {
        if (inputFilePath == null) {
            throw new IllegalArgumentException("Input file path cannot be null.");
        }
        if (resultFilePath == null) {
            throw new IllegalArgumentException("Result file path cannot be null.");
        }
        Path inputPath = Paths.get(inputFilePath);
        Path resultPath = Paths.get(resultFilePath);
        List<String> linesFromFile = Files.lines(inputPath)
                .filter(line -> line.matches("^[\\d\\s]+"))
                .map(line -> line.trim().split("\\s+"))
                .map(arrayOfNumbers -> {
                            int sum = Arrays.asList(arrayOfNumbers).stream().mapToInt(Integer::valueOf).sum();
                            return Arrays.stream(arrayOfNumbers)
                                    .reduce((num1, num2) -> String.format("%s+%s", num1, num2))
                                    .get()
                                    .concat("=")
                                    .concat(Integer.toString(sum));
                        }
                )
                .collect(Collectors.toList());
        Files.write(resultPath, linesFromFile, StandardCharsets.UTF_8);
    }
}
