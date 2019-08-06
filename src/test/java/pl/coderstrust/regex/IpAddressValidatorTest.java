package pl.coderstrust.regex;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IpAddressValidatorTest {

    @Ignore
    @Test
    void shouldCheckAllIpAddresses() {
        for (int i = 0; i <= 255; i++) {
            for (int j = 0; j <= 255; j++) {
                for (int k = 0; k <= 255; k++) {
                    for (int l = 0; l <= 255; l++) {
                        assertTrue(IpAddressValidator.isIpAddress(String.format("%d.%d.%d.%d", i, j, k, l)));
                    }
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"%d.1.1.1", "1.%d.1.1", "1.1.%d.1", "1.1.1.%d"})
    void smartTestForIpAddress(String ipAddressTemplate) {
        for (int i = 0; i <= 255; i++) {
            String ipAddress = String.format(ipAddressTemplate, i);
            assertTrue(IpAddressValidator.isIpAddress(ipAddress));
        }
    }

    @Test
    void shouldThrowExceptionForNullAsInput() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> IpAddressValidator.isIpAddress(null));
        assertEquals("Line cannot be null.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"h.h.h.h", "242345", "sdgasg", "0", "123.390.680.999", "", "            "})
    void shouldReturnFalseForInvalidIpAddress(String ipAddress) {
        assertFalse(IpAddressValidator.isIpAddress(ipAddress));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.1.1.1", "1.2.3.4", "255.255.255.255", "0.0.0.0", "123.190.80.99"})
    void shouldReturnTrueForValidIpAddress(String ipAddress) {
        assertTrue(IpAddressValidator.isIpAddress(ipAddress));
    }
}
