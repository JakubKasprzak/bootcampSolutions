package pl.coderstrust.doYouLoveStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {

    public List<String> readLinesFromFile(String filePath) throws FileNotFoundException {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        }
        return list;
    }

    public void writeLinesToFile(List<String> lines, String filePath) throws IOException {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        if (lines == null) {
            throw new IllegalArgumentException("Lines cannot be null.");
        }
        Path result = Paths.get(filePath);
        Files.write(result, lines, StandardCharsets.UTF_8);
    }
}
