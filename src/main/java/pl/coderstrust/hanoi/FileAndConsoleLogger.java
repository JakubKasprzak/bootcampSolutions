package pl.coderstrust.hanoi;

import java.io.PrintWriter;

public class FileAndConsoleLogger {
    private PrintWriter printWriter;

    public FileAndConsoleLogger(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    void log(String log) {
        System.out.println(log);
        printWriter.println(log);
    }
}
