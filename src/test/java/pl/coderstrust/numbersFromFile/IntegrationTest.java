package pl.coderstrust.numbersFromFile;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class IntegrationTest {

    @Test
    @DisplayName("Should return new file with equations made of numbers extracted from given file.")
    void shouldReturnNewFileWithEquationsMadeOfNumbersFromGivenFile() throws IOException {
        //given
        String inputFilePath = "src/test/resources/1000.txt";
        File input = new File(inputFilePath);
        String resultFilePath = "src/test/resources/output.txt";
        File result = new File(resultFilePath);
        //when
        FileProcessor fileProcessor = new FileProcessor();
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process(inputFilePath, resultFilePath);

//        List<String> resultList = FileProcessor.readLinesFromFile(inputFilePath);
//        List<String> resultLines = new ArrayList<>();
//        for (String line : resultList) {
//            resultLines.add(NumbersProcessor.processLine(line));
//        }
//        FileProcessor.writeLinesToFile(resultLines, resultFilePath);

        //then
        FileUtils.contentEquals(input, result);
    }
}
