package fr.uvsq.cprog.collex;

import org.junit.Test;
import java.io.*;
import java.nio.file.*;
import static org.junit.Assert.*;
import java.util.*;

public class DnsTest {

    @Test
    public void testChargementEtAjout() throws IOException {
        Path tmp = Files.createTempFile("dns", ".txt");
        Files.write(tmp, Arrays.asList("193.51.31.90 www.uvsq.fr"));
        Dns dns = new Dns(tmp.toString());

        assertNotNull(dns.getItem(new NomMachine("www.uvsq.fr")));
        dns.addItem(new AdresseIP("193.51.25.24"), new NomMachine("pikachu.uvsq.fr"));
        assertNotNull(dns.getItem(new NomMachine("pikachu.uvsq.fr")));
    }
}
