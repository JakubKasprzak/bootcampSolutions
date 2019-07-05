package pl.coderstrust.hanoi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class HanoiTowers {
    private static final int TOTAL_NUMBER_OF_DISCS = 3;

    public static void main(String[] args) throws IOException {
        runHanoi(TOTAL_NUMBER_OF_DISCS);
    }

    public static Stack<Integer> runHanoi(int numberOfDiscsOnPileA) throws IOException {
        FileWriter output = new FileWriter("output.txt");
        PrintWriter printWriter = new PrintWriter(output);
        Stack<Integer> pileA = new Stack<>();
        Stack<Integer> pileB = new Stack<>();
        Stack<Integer> pileC = new Stack<>();
        for (int numberOfDisc = numberOfDiscsOnPileA; numberOfDisc > 0; numberOfDisc--)
            pileA.push(numberOfDisc);
        solveHanoi(numberOfDiscsOnPileA, pileA, pileB, pileC, printWriter);
        printWriter.close();
        return pileC;
    }

    private static void solveHanoi(int discOnTop, Stack pileFrom, Stack pileAuxiliary, Stack pileTo, PrintWriter printWriter) {
        if (discOnTop > 0) {
            solveHanoi(discOnTop - 1, pileFrom, pileTo, pileAuxiliary, printWriter);
            int numberOfDisc = (int) pileFrom.pop();
            pileTo.push(numberOfDisc);
            System.out.println("Move disc " + discOnTop + " from pile " + pileFrom + " to pile " + pileTo);
            printWriter.println("Move disc " + discOnTop + " from pile " + pileFrom + " to pile " + pileTo);
            solveHanoi(discOnTop - 1, pileAuxiliary, pileFrom, pileTo, printWriter);
        }
    }
}
