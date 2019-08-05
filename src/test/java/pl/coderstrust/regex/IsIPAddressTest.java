package pl.coderstrust.regex;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IsIPAddressTest {

    @Ignore
    @Test
    public void shouldReturnTrueIfLineIsAnIPAddressLongTest() {
        String wholeNumber;
        for (int i = 0; i <= 255; i++) {
            for (int j = 0; j <= 255; j++) {
                for (int k = 0; k <= 255; k++) {
                    for (int l = 0; l <= 255; l++) {
                        wholeNumber = i + "." + j + "." + k + "." + l;
                        assertTrue(IpAddressValidator.isIpAddress(wholeNumber));
                    }
                }
            }
        }
    }

    @Test
    public void shouldReturnTrueIfLineIsAnIPAddress() {
        for (int i = 0; i <= 255; i++) {
            String first = i + ".1.1.1";
            String second = "1." + i + ".1.1";
            String third = "1.1." + i + ".1";
            String fourth = "1.1.1." + i;
            assertTrue(IpAddressValidator.isIpAddress(first));
            assertTrue(IpAddressValidator.isIpAddress(second));
            assertTrue(IpAddressValidator.isIpAddress(third));
            assertTrue(IpAddressValidator.isIpAddress(fourth));
        }
    }

    @Test
    public void shouldThrowExceptionForNullAsLine() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> IpAddressValidator.isIpAddress(null));
        assertEquals("Line cannot be null or empty.", thrown.getMessage());
    }

    @Test
    public void shouldThrowExceptionForEmptyLine() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> IpAddressValidator.isIpAddress(""));
        assertEquals("Line cannot be null or empty.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"h.h.h.h", "242345", "sdgasg", "0", "123.390.680.999"})
    public void shouldReturnFalseForInvalidLines(String argument) {
        assertFalse(IpAddressValidator.isIpAddress(argument));
    }
}
