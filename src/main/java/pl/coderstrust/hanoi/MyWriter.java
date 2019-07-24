package pl.coderstrust.hanoi;

import java.io.PrintWriter;

public class MyWriter {
    private PrintWriter printWriter;

    public MyWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    void println(String log) {
        System.out.println(log);
        printWriter.println(log);
    }
}
