package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class NomMachineTest {

    @Test
    public void testNom() {
        NomMachine n = new NomMachine("www.uvsq.fr");
        assertEquals("www.uvsq.fr", n.getNom());
    }

    @Test
    public void testEquals() {
        NomMachine n1 = new NomMachine("poste.uvsq.fr");
        NomMachine n2 = new NomMachine("poste.uvsq.fr");
        assertEquals(n1, n2);
    }
}
