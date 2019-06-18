package pl.coderstrust.foobar;

import java.util.Arrays;

public class FooBar {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(createFooBar(100)));
    }

    private static String[] createFooBar(int n) {
        String[] foobar = new String[n + 1];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            String j = Integer.toString(i);
            builder.append(j).append(" ");
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
