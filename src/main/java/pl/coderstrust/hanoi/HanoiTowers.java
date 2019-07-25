package pl.coderstrust.hanoi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class HanoiTowers {
    private static final int TOTAL_NUMBER_OF_DISCS = 3;


    public static void main(String[] args) throws IOException {
        prepareHanoi(TOTAL_NUMBER_OF_DISCS);

    }

    public static void prepareHanoi(int numberOfDiscsOnPileA) throws IOException {
        HanoiTower pileA = new HanoiTower("A");
        HanoiTower pileB = new HanoiTower("B");
        HanoiTower pileC = new HanoiTower("C");
        for (int numberOfDisc = numberOfDiscsOnPileA; numberOfDisc > 0; numberOfDisc--) {
            pileA.getDiscs().push(numberOfDisc);
        }
        hanoi(pileA, pileB, pileC);
    }

    public static HanoiTower hanoi(HanoiTower pileA, HanoiTower pileB, HanoiTower pileC) throws IOException {
        if (pileA.getDiscs().isEmpty()) {
            throw new EmptyStackException();
        } else if ((pileB.getDiscs().size() > 0) || (pileC.getDiscs().size() > 0)) {
            throw new IllegalArgumentException("Piles B and C must be empty");
        } else {
            FileWriter output = new FileWriter("output.txt");
            PrintWriter printWriter = new PrintWriter(output);
            MyWriter myWriter = new MyWriter(printWriter);
            solveHanoi(pileA.getDiscs().size(), pileA, pileB, pileC, myWriter);
            printWriter.close();
        }
        return pileC;
    }

    private static void solveHanoi(int discOnTop, HanoiTower pileFrom, HanoiTower pileAuxiliary, HanoiTower pileTo, MyWriter myWriter) {
        if (discOnTop > 0) {
            solveHanoi(discOnTop - 1, pileFrom, pileTo, pileAuxiliary, myWriter);
            int numberOfDisc = pileFrom.getDiscs().pop();
            pileTo.getDiscs().push(numberOfDisc);
            myWriter.println("Move disc " + discOnTop + " from pile " + pileFrom.getName() + " to pile " + pileTo.getName());
            solveHanoi(discOnTop - 1, pileAuxiliary, pileFrom, pileTo, myWriter);
        }
    }
}
