public class CommandeAdresse implements Commande {
    private String ip;
    public CommandeAdresse(String ligne) { this.ip = ligne.trim(); }
    public void execute(Dns dns, DnsTUI tui) {
        DnsItem item = dns.getItem(new AdresseIP(ip));
        if (item != null) tui.affiche(item.getNomMachine().toString());
        else tui.affiche("Adresse IP introuvable.");
    }
}
