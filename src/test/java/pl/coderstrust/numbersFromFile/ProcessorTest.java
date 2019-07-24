//package pl.coderstrust.numbersFromFile;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class ProcessorTest {
//
//    @Mock
//    NumbersProcessor numbersProcessor;
//    @Mock
//    FileProcessor fileProcessor;
//
//    @InjectMocks
//    Processor processor;
//
//    @Test
//    public void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
//        // given
//        when(fileProcessor.readLinesFromFile("fileName.txt")).thenReturn(Arrays.asList("1 2 3", "4 5 6"));
//        when(numbersProcessor.processLine("1 2 3")).thenReturn("1+2+3=6");
//
//        // when
//        processor.process("fileName.txt", "output.txt");
//
//        // then
//        verify(fileProcessor).readLinesFromFile(...
//        verify(numbersProcessor).processLine(....
//        verify(fileProcessor).writeLinesToFile(....
//    }
//}
