package pl.coderstrust.hanoi;

import java.util.Stack;

public class HanoiTower {

    private Stack<Integer> stack;
    private String name;

    public HanoiTower(String name) {
        stack = new Stack<>();
        this.name = name;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public String getName() {
        return name;
    }
}
