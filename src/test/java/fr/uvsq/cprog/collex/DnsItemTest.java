package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class DnsItemTest {

    @Test
    public void testToString() {
        AdresseIP ip = new AdresseIP("193.51.31.90");
        NomMachine nom = new NomMachine("www.uvsq.fr");
        DnsItem item = new DnsItem(ip, nom);
        assertTrue(item.toString().contains("193.51.31.90"));
    }

    @Test
    public void testEquals() {
        DnsItem i1 = new DnsItem(new AdresseIP("1.2.3.4"), new NomMachine("a.b.c"));
        DnsItem i2 = new DnsItem(new AdresseIP("1.2.3.4"), new NomMachine("a.b.c"));
        assertEquals(i1, i2);
    }
}
