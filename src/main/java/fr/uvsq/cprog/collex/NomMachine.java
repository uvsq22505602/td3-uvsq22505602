public class NomMachine {
    private String nom;

    public NomMachine(String nom) {
        if (!nom.contains(".")) {
            throw new IllegalArgumentException("Nom de machine invalide : il doit contenir un point");
        }
        String[] parties = nom.split("\\.", 2);
        if (parties[0].isEmpty() || parties[1].isEmpty()) {
            throw new IllegalArgumentException("Nom de machine invalide : partie vide");
        }
        this.nom = nom;
    }

    public String getNomComplet() {
        return nom;
    }

    public String getMachine() {
        return nom.split("\\.", 2)[0];
    }

    public String getDomaine() {
        return nom.split("\\.", 2)[1];
    }

    @Override 
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NomMachine)) return false;
        NomMachine other = (NomMachine) obj;
        return this.nom.equals(other.nom);
    }

    @Override 
    public int hashCode() {
        return nom.hashCode();
    }
}
