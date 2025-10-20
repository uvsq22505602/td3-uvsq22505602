public class DnsItem {
    private AdresseIP adresseIP;
    private NomMachine nomMachine;

    public DnsItem(AdresseIP adresseIP, NomMachine nomMachine) {
        if (adresseIP == null || nomMachine == null) {
            throw new IllegalArgumentException("DnsItem invalide : adresseIP ou nomMachine null");
        }
        this.adresseIP = adresseIP;
        this.nomMachine = nomMachine;
    }

    @Override
    public String toString() {
        return adresseIP + " " + nomMachine;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DnsItem)) return false;
        DnsItem other = (DnsItem) obj;
        return this.adresseIP.equals(other.adresseIP)
            && this.nomMachine.equals(other.nomMachine);
    }

    @Override 
    public int hashCode() {
        return java.util.Objects.hash(adresseIP, nomMachine);
    }

    public AdresseIP getAdresseIP() {
        return adresseIP;
    }
    
    public NomMachine getNomMachine() {
        return nomMachine;
    }
}
