package pl.coderstrust.numbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        if (numbersProcessor == null) {
            throw new IllegalArgumentException("NumbersProcessor cannot be null.");
        }
        if (fileProcessor == null) {
            throw new IllegalArgumentException("FileProcessor cannot be null.");
        }
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String inputFilePath, String resultFilePath) throws IOException {
        if (inputFilePath == "") {
            throw new IllegalArgumentException("File path is not valid.");
        }
        if (inputFilePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        if (resultFilePath == "") {
            throw new IllegalArgumentException("File path is not valid.");
        }
        if (resultFilePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        List<String> linesFromFile = fileProcessor.readLinesFromFile(inputFilePath);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            resultLines.add(numbersProcessor.processLine(line));
        }
        fileProcessor.writeLinesToFile(resultLines, resultFilePath);
    }
}
