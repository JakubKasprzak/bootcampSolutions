package pl.coderstrust.doYouLoveStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Processor {

    public static void main(String[] args) throws IOException {
        String inputFilePath = "src/test/resources/1000.txt";
        Path inputPath = Paths.get(inputFilePath);
        String resultFilePath = "src/test/resources/output.txt";
        Path resultPath = Paths.get(resultFilePath);
        process(inputPath, resultPath);


    }

    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        if (numbersProcessor == null) {
            throw new IllegalArgumentException("Numbers Processor cannot be null.");
        }
        if (fileProcessor == null) {
            throw new IllegalArgumentException("File Processor cannot be null.");
        }
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(Path inputFilePath, Path resultFilePath) throws IOException {
        if (inputFilePath == null) {
            throw new IllegalArgumentException("Input file path cannot be null.");
        }
        if (resultFilePath == null) {
            throw new IllegalArgumentException("Result file path cannot be null.");
        }

        List<String> linesFromFile = Files.lines(inputFilePath)
                .filter(line -> line.matches("^[\\d\\s]+"))
                .map(String::trim)
                .map(line -> numbersProcessor.processLine(line))
//                .Arrays.stream(line.toString().split(","))
                .collect(Collectors.toList());


        //ściągnij plugin save actions
        //map to zamiana obiektu w inny np. typ integer zmienia na stringi, map nie kończy streama
        //filter przepuszcza tylko obiekty które spełniają warunek
        //forEach musi być na końcu
        //collect też na końcu


        List list = linesFromFile.forEach(line -> {
                    Arrays.stream(line.toString().split(","))
                            .map(String::trim)
                            .toArray(String[]::new);
                }
        )));
        System.out.println(linesFromFile.toArray().toString());


//        List<String> linesFromFile = fileProcessor.readLinesFromFile(inputFilePath);
//                List< String > resultLines = new ArrayList<>();
//        for (String line : linesFromFile) {
//            resultLines.add(numbersProcessor.processLine(line));
//        }
//        fileProcessor.writeLinesToFile(resultLines, resultFilePath);
    }
}
