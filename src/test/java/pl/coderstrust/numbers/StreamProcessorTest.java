package pl.coderstrust.numbers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class StreamProcessorTest {
    private StreamProcessor streamProcessor;

    @BeforeEach
    void setup() {
        streamProcessor = new StreamProcessor();
    }

    @Test
    @DisplayName("Should return new file with equations made of numbers extracted from given file.")
    void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
        //given
        String inputFile = "src/test/resources/1000.txt";
        String outputFile = "src/test/resources/output.txt";
        String expectedFile = "src/test/resources/expected2.txt";

        //when
        streamProcessor.process(inputFile, outputFile);

        //then
        byte[] expected = Files.readAllBytes(Paths.get(expectedFile));
        byte[] actual = Files.readAllBytes(Paths.get(outputFile));
        assertArrayEquals(expected, actual);
    }
}
