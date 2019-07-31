package pl.coderstrust.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProcessorTest {
    private String inputFilePath = "src/test/resources/someNumbersTest.txt";
    private String resultFilePath = "src/test/resources/resultTest.txt";
    @Mock
    NumbersProcessor numbersProcessor;

    @Mock
    FileProcessor fileProcessor;

    @InjectMocks
    Processor processor;

    @Test
    void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
        // given
        when(fileProcessor.readLinesFromFile(inputFilePath)).thenReturn(Arrays.asList("1 2 3", "4 5 6"));
        Mockito.doReturn("1+2+3=6").when(numbersProcessor).processLine("1 2 3");
        Mockito.doReturn("4+5+6=15").when(numbersProcessor).processLine("4 5 6");

        // when
        processor.process(inputFilePath, resultFilePath);

        // then
        verify(fileProcessor).readLinesFromFile(inputFilePath);
        verify(numbersProcessor, times(1)).processLine("1 2 3");
        verify(numbersProcessor, times(1)).processLine("4 5 6");
        verify(fileProcessor).writeLinesToFile(Arrays.asList("1+2+3=6", "4+5+6=15"), resultFilePath);
    }
}
