package pl.coderstrust.foobar;

public class FooBar {

    public static void main(String[] args) {
        printFooBar(100);
    }

    private static void printFooBar(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            builder.append(i).append(" ");
            if (i % 3 == 0) {
                builder.append("Foo");
            }
            if (i % 5 == 0) {
                builder.append("Bar");
            }
            System.out.println(builder.toString());
            builder.setLength(0);
        }
    }
}
