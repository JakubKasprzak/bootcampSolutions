package pl.coderstrust.hanoi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;

public class HanoiTowers {
    private static final int TOTAL_NUMBER_OF_DISCS = 3;

    public static void main(String[] args) throws IOException {
        prepareHanoi();
    }

    private static void prepareHanoi() throws IOException {
        HanoiTower pileA = new HanoiTower("A");
        HanoiTower pileB = new HanoiTower("B");
        HanoiTower pileC = new HanoiTower("C");
        for (int numberOfDisc = HanoiTowers.TOTAL_NUMBER_OF_DISCS; numberOfDisc > 0; numberOfDisc--) {
            pileA.getDiscs().push(numberOfDisc);
        }
        hanoi(pileA, pileB, pileC);
    }

    public static void hanoi(HanoiTower pileA, HanoiTower pileB, HanoiTower pileC) throws IOException {
        if (pileA.getDiscs().isEmpty()) {
            throw new EmptyStackException();
        }
        if ((pileB.getDiscs().size() > 0) || (pileC.getDiscs().size() > 0)) {
            throw new IllegalArgumentException("Piles B and C must be empty");
        }
        FileWriter output = new FileWriter("output.txt");
        PrintWriter printWriter = new PrintWriter(output);
        FileAndConsoleLogger fileAndConsoleLogger = new FileAndConsoleLogger(printWriter);
        solveHanoi(pileA.getDiscs().size(), pileA, pileB, pileC, fileAndConsoleLogger);
        printWriter.close();
    }

    private static void solveHanoi(int discOnTop, HanoiTower pileFrom, HanoiTower pileAuxiliary, HanoiTower pileTo, FileAndConsoleLogger fileAndConsoleLogger) {
        if (discOnTop > 0) {
            solveHanoi(discOnTop - 1, pileFrom, pileTo, pileAuxiliary, fileAndConsoleLogger);
            int numberOfDisc = pileFrom.getDiscs().pop();
            pileTo.getDiscs().push(numberOfDisc);
            fileAndConsoleLogger.log("Move disc " + discOnTop + " from pile " + pileFrom.getName() + " to pile " + pileTo.getName());
            solveHanoi(discOnTop - 1, pileAuxiliary, pileFrom, pileTo, fileAndConsoleLogger);
        }
    }
}
