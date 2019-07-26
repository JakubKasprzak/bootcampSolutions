package pl.coderstrust.numbersFromFile;

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

    public static void main(String[] args) {
    }

    public List<String> readLinesFromFile(String inputFilePath) {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(inputFilePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        return list;
    }

    void writeLinesToFile(List<String> resultLines, String resultFilePath) throws IOException {
        Path result = Paths.get(resultFilePath);
        Files.write(result, resultLines, StandardCharsets.UTF_8);
    }
}
