package pl.coderstrust.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProcessorIT {
    private Processor processor;

    @BeforeEach
    void setup() {
        FileProcessor fileProcessor = new FileProcessor();
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        processor = new Processor(numbersProcessor, fileProcessor);
    }

    @Test
    @DisplayName("Should return new file with equations made of numbers extracted from given file.")
    void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
        //given
        String inputFile = "src/test/resources/1000.txt";
        String outputFile = "src/test/resources/output.txt";
        String expectedFile = "src/test/resources/expected.txt";

        //when
        processor.process(inputFile, outputFile);

        //then
        byte[] expected = Files.readAllBytes(Paths.get(expectedFile));
        byte[] actual = Files.readAllBytes(Paths.get(outputFile));
        assertArrayEquals(expected, actual);
    }

    @Test
    void processorMethodShouldThrowExceptionForNullAsInputFilePath() {
        assertThrows(IllegalArgumentException.class, () -> processor.process(null, "file.txt"));
    }

    @Test
    void processorMethodShouldThrowExceptionForNullAsResultFilePath() {
        assertThrows(IllegalArgumentException.class, () -> processor.process("file.txt", null));
    }
}
