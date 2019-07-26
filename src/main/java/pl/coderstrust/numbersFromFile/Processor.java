package pl.coderstrust.numbersFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static NumbersProcessor numbersProcessor;
    private static FileProcessor fileProcessor;

    public static void main(String[] args) throws IOException {
        String inputFilePath = "src/main/java/pl/coderstrust/numbersFromFile/1000.txt";
        String outputFilePath = "src/main/java/pl/coderstrust/numbersFromFile/result.txt";
        process(inputFilePath, outputFilePath);
    }

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public static void process(String inputFilePath, String resultFilePath) throws IOException {
        List<String> linesFromFile = fileProcessor.readLinesFromFile(inputFilePath);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            resultLines.add(numbersProcessor.processLine(line));
        }
        fileProcessor.writeLinesToFile(resultLines, resultFilePath);
    }
}
