package pl.coderstrust.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FileProcessorTest {
    private FileProcessor fileProcessor;

    @BeforeEach
    void setup() {
        fileProcessor = new FileProcessor();
    }

    @Test
    void readLinesFromFileMethodShouldThrowExceptionForNullAsFilePath() {
        assertThrows(IllegalArgumentException.class, () -> fileProcessor.readLinesFromFile(null));
    }

    @Test
    void writeLinesToFileMethodShouldThrowExceptionForNullLines() {
        assertThrows(IllegalArgumentException.class, () -> fileProcessor.writeLinesToFile(null, "file.txt"));
    }

    @Test
    void writeLinesToFileMethodShouldThrowExceptionForNullAsFilePath() {
        assertThrows(IllegalArgumentException.class, () -> fileProcessor.writeLinesToFile(new ArrayList<>(), null));
    }
}
