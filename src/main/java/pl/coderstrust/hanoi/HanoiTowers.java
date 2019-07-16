package pl.coderstrust.hanoi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class HanoiTowers {
    private static final int TOTAL_NUMBER_OF_DISCS = 3;


    public static void main(String[] args) throws IOException {
        hanoi(TOTAL_NUMBER_OF_DISCS);
    }

    public static Stack<Integer> hanoi(int numberOfDiscsOnPileA) throws IOException {
        FileWriter output = new FileWriter("output.txt");
        PrintWriter printWriter = new PrintWriter(output);
        HanoiTower pileA = new HanoiTower("A");
        HanoiTower pileB = new HanoiTower("B");
        HanoiTower pileC = new HanoiTower("C");
        for (int numberOfDisc = numberOfDiscsOnPileA; numberOfDisc > 0; numberOfDisc--) {
            pileA.getDiscs().push(numberOfDisc);
        }
        solveHanoi(numberOfDiscsOnPileA, pileA, pileB, pileC, printWriter);
        printWriter.close();
        return pileC.getDiscs();
    }

    private static void solveHanoi(int discOnTop, HanoiTower pileFrom, HanoiTower pileAuxiliary, HanoiTower pileTo, PrintWriter printWriter) {
        if (discOnTop > 0) {
            solveHanoi(discOnTop - 1, pileFrom, pileTo, pileAuxiliary, printWriter);
            int numberOfDisc = pileFrom.getDiscs().pop();
            pileTo.getDiscs().push(numberOfDisc);
            System.out.println("Move disc " + discOnTop + " from pile " + pileFrom.getName() + " to pile " + pileTo.getName());
            printWriter.println("Move disc " + discOnTop + " from pile " + pileFrom.getName() + " to pile " + pileTo.getName());
            solveHanoi(discOnTop - 1, pileAuxiliary, pileFrom, pileTo, printWriter);
        }
    }
}
