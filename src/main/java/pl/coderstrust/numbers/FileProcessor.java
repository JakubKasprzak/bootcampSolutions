package pl.coderstrust.numbers;

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
        if (filePath.equals("")) {
            throw new IllegalArgumentException("File path is not valid.");
        }
        if (filePath.equals(null)) {
            throw new IllegalArgumentException("File path is not valid.");
        }
        List<String> list = new ArrayList<>();
        try (
                Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
        }
        return list;
    }

    public void writeLinesToFile(List<String> lines, String filePath) throws IOException {
        if (filePath.equals("")) {
            throw new IllegalArgumentException("File path is not valid.");
        }
        if (filePath.equals(null)) {
            throw new IllegalArgumentException("File path is not valid.");
        }
        if (lines == null) {
            throw new IllegalArgumentException("List cannot be null.");
        }
        Path result = Paths.get(filePath);
        Files.write(result, lines, StandardCharsets.UTF_8);
    }
}
