package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FileProcessorTest {
    private FileProcessor fileProcessor = new FileProcessor();
    private String filePath = "src/test/resources/numbersFromFileTest.txt";
    private List<String> expected = new ArrayList<>();

    @Test
    @DisplayName("Should throw exception for null argument.")
    void shouldThrowExceptionForNullArgument() {
        assertThrows(NullPointerException.class, () -> fileProcessor.readLinesFromFile(null));
        assertThrows(NullPointerException.class, () -> fileProcessor.writeLinesToFile(null, filePath));
        assertThrows(NullPointerException.class, () -> fileProcessor.writeLinesToFile(expected, null));
    }

    @Test
    @DisplayName("Should throw exception for an empty path.")
    void shouldThrowExceptionForEmptyPath() {
        assertThrows(IllegalArgumentException.class, () -> fileProcessor.readLinesFromFile(""));
        assertThrows(IllegalArgumentException.class, () -> fileProcessor.writeLinesToFile(expected, ""));
    }
}
