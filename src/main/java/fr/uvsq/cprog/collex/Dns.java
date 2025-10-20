import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Dns {
    private List<DnsItem> items;
    private Path fichier;

    public Dns(String nomFichier) {
        this.items = new ArrayList<>();
        this.fichier = Paths.get(nomFichier);

        try {
            List<String> lignes = Files.readAllLines(fichier);
            for (String ligne : lignes) {
                if (ligne.isBlank()) continue;
                String[] parties = ligne.split(" ");
                if (parties.length != 2) continue;
                AdresseIP ip = new AdresseIP(parties[0]);
                NomMachine nom = new NomMachine(parties[1]);
                items.add(new DnsItem(ip, nom));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur de lecture du fichier : " + e.getMessage());
        }
    }

    public DnsItem getItem(NomMachine nom) {
        for (DnsItem item : items) {
            if (item.getNomMachine().equals(nom)) {
                return item;
            }
        }
        return null;
    }

    public DnsItem getItem(AdresseIP ip) {
        for (DnsItem item : items) {
            if (item.getAdresseIP().equals(ip)) {
                return item;
            }
        }
        return null;
    }

    public List<DnsItem> getItems(String domaine) {
        List<DnsItem> resultat = new ArrayList<>();
        for (DnsItem item : items) {
            if (item.getNomMachine().getDomaine().equals(domaine)) {
                resultat.add(item);
            }
        }
        return resultat;
    }

    public void addItem(AdresseIP ip, NomMachine nom) {
        for (DnsItem item : items) {
            if (item.getAdresseIP().equals(ip)) {
                throw new IllegalArgumentException("ERREUR : L'adresse IP existe déjà !");
            }
            if (item.getNomMachine().equals(nom)) {
                throw new IllegalArgumentException("ERREUR : Le nom de machine existe déjà !");
            }
        }
        items.add(new DnsItem(ip, nom));
        save();
    }

    private void save() {
        List<String> lignes = new ArrayList<>();
        for (DnsItem item : items) {
            lignes.add(item.getAdresseIP() + " " + item.getNomMachine());
        }
        try {
            Files.write(fichier, lignes);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la sauvegarde du fichier : " + e.getMessage());
        }
    }
}
