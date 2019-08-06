package pl.coderstrust.regex;

public class IpAddressValidator {
    private static final String REGEX = "\\b(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\b";

    public static boolean isIpAddress(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Line cannot be null.");
        }
        return (input.matches(REGEX));
    }
}
