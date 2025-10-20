public class CommandeNom implements Commande {
    private String nom;
    public CommandeNom(String ligne) { this.nom = ligne.trim(); }
    public void execute(Dns dns, DnsTUI tui) {
        DnsItem item = dns.getItem(new NomMachine(nom));
        if (item != null) tui.affiche(item.getAdresseIP().toString());
        else tui.affiche("Nom de machine introuvable.");
    }
}
