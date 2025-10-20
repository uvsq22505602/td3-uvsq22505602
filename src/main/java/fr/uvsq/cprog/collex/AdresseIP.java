public class AdresseIP {
    private String adresse;

    public AdresseIP(String adresse) {
        // Vérification du format
        String[] valeurs = adresse.split("\\."); // ✅ un seul antislash échappé
        if (valeurs.length != 4) {
            throw new IllegalArgumentException("Adresse IP invalide : mauvais nombre d'octets");
        }

        for (String valeur : valeurs) {
            try {
                int nombre = Integer.parseInt(valeur); // ✅ bonne syntaxe
                if (nombre < 0 || nombre > 255) {
                    throw new IllegalArgumentException("Adresse IP invalide : " + valeur + " hors bornes 0–255");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Adresse IP invalide : " + valeur + " n'est pas un entier");
            }
        }

        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AdresseIP)) return false;
        AdresseIP other = (AdresseIP) obj;
        return this.adresse.equals(other.adresse); // ✅ .equals() et non ==
    }

    @Override
    public int hashCode() {
        return adresse.hashCode(); // ✅ basé sur le texte de l'IP
    }

    @Override
    public String toString() {
        return adresse; // ✅ inutile de faire .toString() sur une String
    }

    public String getAdresse() {
        return adresse;
    }
}
