package pl.coderstrust.numbersFromFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static NumbersProcessor numbersProcessor;
    private static FileProcessor fileProcessor;

    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get("1000.txt");
        Path resultFile = Paths.get("result.txt");
        process(inputFile.getFileName().toString(), resultFile.getFileName().toString());
    }

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public static void process(String fileName, String resultFileName) throws IOException {
        List<String> linesFromFile = fileProcessor.readLinesFromFile(fileName);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            if (line.matches("[ 0-9]+")) {
                resultLines.add(numbersProcessor.processLine(line));
            }
        }
        fileProcessor.writeLinesToFile(resultLines, resultFileName);
    }
}
