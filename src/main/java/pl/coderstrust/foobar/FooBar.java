package pl.coderstrust.foobar;

import java.util.Arrays;

public class FooBar {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getFooBar(100)));
    }

    public static String[] getFooBar(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be lower than zero.");
        }
        String[] foobar = new String[number + 1];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= number; i++) {
            builder.append(i).append(" ");
            if (i % 3 == 0) {
                builder.append("Foo");
            }
            if (i % 5 == 0) {
                builder.append("Bar");
            }
            foobar[i] = builder.toString();
            builder.setLength(0);
        }
        return foobar;
    }
}
