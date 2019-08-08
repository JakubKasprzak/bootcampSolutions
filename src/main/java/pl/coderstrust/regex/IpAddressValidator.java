package pl.coderstrust.regex;

import java.util.regex.Pattern;

public class IpAddressValidator {
    private static final String REGEX = "\\b(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\b";
    private static final Pattern pattern = Pattern.compile(REGEX);

    public static boolean isIpAddress(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }
        return pattern.matcher(input).matches();
    }
}
