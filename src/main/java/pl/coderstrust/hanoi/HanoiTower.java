package pl.coderstrust.hanoi;

import java.util.Stack;

public class HanoiTower {

    private Stack<Integer> discs;
    private String name;

    public HanoiTower(String name) {
        discs = new Stack<>();
        this.name = name;
    }

    public Stack<Integer> getDiscs() {
        return discs;
    }

    public String getName() {
        return name;
    }
}
