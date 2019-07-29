package pl.coderstrust.numbers;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProcessorIT {
    private FileProcessor fileProcessor = new FileProcessor();
    private NumbersProcessor numbersProcessor = new NumbersProcessor();
    private Processor processor = new Processor(numbersProcessor, fileProcessor);
    private String inputFilePath = "src/test/resources/1000.txt";
    private String resultFilePath = "src/test/resources/result.txt";

    @Test
    @DisplayName("Should return new file with equations made of numbers extracted from given file.")
    void shouldReturnNewFileWithEquationsMadeOfNumbersFromGivenFile() throws IOException {
        //given
        File expected = new File(inputFilePath);
        File result = new File(resultFilePath);

        //when
        processor.process(inputFilePath, resultFilePath);

        //then
        FileUtils.contentEquals(expected, result);
    }

    @Test
    @DisplayName("Should throw exception for null argument.")
    void shouldThrowExceptionForNullArgument() {
        assertThrows(NullPointerException.class, () -> processor.process(null, resultFilePath));
        assertThrows(NullPointerException.class, () -> processor.process(inputFilePath, null));
    }

    @Test
    @DisplayName("Should throw exception for an empty path.")
    void shouldThrowExceptionForEmptyPath() {
        assertThrows(IllegalArgumentException.class, () -> processor.process("", resultFilePath));
        assertThrows(IllegalArgumentException.class, () -> processor.process(inputFilePath, ""));
    }
}
