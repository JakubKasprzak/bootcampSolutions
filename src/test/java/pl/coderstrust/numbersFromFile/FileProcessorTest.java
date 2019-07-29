package pl.coderstrust.numbersFromFile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileProcessorTest {

    @Test
    @DisplayName("Should return list made of extracted lines from given file path.")
    void shouldReturnListMadeOfGivenFile() {
        //given
        List<String> expected = new ArrayList<>();
        expected.add("1 2 3");
        expected.add("4 5 6");
        expected.add("");
        expected.add("this is some sentence");
        String filePath = "src/test/resources/numbersFromFileTest.txt";

        //when
        List<String> result = FileProcessor.readLinesFromFile(filePath);

        //then
        assertEquals(expected, result);
    }
}
