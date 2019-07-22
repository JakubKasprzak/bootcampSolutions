package pl.coderstrust.numbersFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static NumbersProcessor numbersProcessor;
    private static FileProcessor fileProcessor;

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("src/main/java/pl/coderstrust/numbersFromFile/1000.txt");
        File resultFile = new File("src/main/java/pl/coderstrust/numbersFromFile/result.txt");
        process(inputFile.getName(), resultFile.getName());
    }

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public static void process(String fileName, String resultFileName) throws FileNotFoundException {
        List<String> linesFromFile = fileProcessor.readLinesFromFile(fileName);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            resultLines.add(numbersProcessor.processLine(line));
        }
        fileProcessor.writeLinesToFile(resultLines, resultFileName);
    }
}
