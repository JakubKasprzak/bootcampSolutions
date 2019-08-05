package pl.coderstrust.regex;

public class IpAddressValidator {

    public static boolean isIpAddress(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException("Line cannot be null or empty.");
        }
        return (line.matches("\\b(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\b"));
    }
}
