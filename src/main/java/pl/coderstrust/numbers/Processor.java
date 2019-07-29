package pl.coderstrust.numbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    void process(String inputFilePath, String resultFilePath) throws IOException {
        if (!arePathsValid(inputFilePath, resultFilePath)) {
            throw new IllegalArgumentException("File path is not valid.");
        }
        List<String> linesFromFile = fileProcessor.readLinesFromFile(inputFilePath);
        List<String> resultLines = new ArrayList<>();
        for (
                String line : linesFromFile) {
            resultLines.add(numbersProcessor.processLine(line));
        }
        fileProcessor.writeLinesToFile(resultLines, resultFilePath);
    }

    private static boolean arePathsValid(String line1, String line2) {
        if (line1.equals("")) {
            return false;
        }
        if (line2.equals("")) {
            return false;
        }
        return true;
    }
}
