package pl.coderstrust.numbersFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {


    public static void main(String[] args) {
    }

    static public List<String> readLinesFromFile(String fileName) throws FileNotFoundException {
        File input = new File("src/main/java/pl/coderstrust/numbersFromFile/1000.txt");
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        scanner.close();
        return list;
    }

    public static void writeLinesToFile(List<String> resultLines, String resultFileName) {
    }
}
