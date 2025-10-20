package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdresseIPTest {

    @Test
    public void testAdresseValide() {
        AdresseIP ip = new AdresseIP("192.168.0.1");
        assertEquals("192.168.0.1", ip.getAdresse());
    }

    @Test(expected = NumberFormatException.class)
    public void testAdresseInvalide() {
        new AdresseIP("192.abc.0.1");
    }

    @Test
    public void testEquals() {
        AdresseIP ip1 = new AdresseIP("10.0.0.1");
        AdresseIP ip2 = new AdresseIP("10.0.0.1");
        assertEquals(ip1, ip2);
    }
}
