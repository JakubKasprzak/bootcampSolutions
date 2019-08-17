package pl.coderstrust.newinjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IntroducedInJava7 {
    String stringPath = "c:/folder/folder2/somePath.txt";
    Path path = Paths.get(stringPath);

    public void workingWithPath() throws IOException {
        System.out.println("Number of Nodes:" + path.getNameCount());
        System.out.println("File Name:" + path.getFileName());
        System.out.println("File Root:" + path.getRoot());
        System.out.println("File Parent:" + path.getParent());
    }

    public String oldWay() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(stringPath));
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return stringPath;
    }

    public String tryWithRecourses() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(stringPath))) {
            return br.readLine();
        }
    }

    public int underscoresInNumericLiterals() throws IOException {
        int one_million = 1_000_000;
        return one_million;
    }

    public int binaryLiterals() throws IOException {
        int binary = 0b1001_1001;
        return binary;
    }

    public String multipleExceptionCatching() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(stringPath));
        try {
            return br.readLine();
        } catch (IOException | IllegalArgumentException ex) {
            //log
            throw ex;
        }
    }
}
