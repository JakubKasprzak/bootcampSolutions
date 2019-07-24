package pl.coderstrust.numbersFromFile;

import java.io.File;
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

    static public List<String> readLinesFromFile(String inputFilePath) throws IOException {
        File input = new File(inputFilePath);
        Scanner scanner = new Scanner(input);
        //scannera używać w bloku "try with resources"
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        scanner.close();
        return list;
    }

    public static void writeLinesToFile(List<String> resultLines, String resultFileName) throws IOException {
        Path result = Paths.get("src/main/java/pl/coderstrust/numbersFromFile/result.txt");
        Files.write(result, resultLines, StandardCharsets.UTF_8);
    }
}
