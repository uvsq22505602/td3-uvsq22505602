public class CommandeAdd implements Commande {
    private String ligne;
    public CommandeAdd(String ligne) { this.ligne = ligne.trim(); }
    public void execute(Dns dns, DnsTUI tui) {
        String[] parties = ligne.split(" ");
        if (parties.length != 3) {
            tui.affiche("Usage : add <adresseIP> <nomMachine>");
            return;
        }
        try {
            dns.addItem(new AdresseIP(parties[1]), new NomMachine(parties[2]));
            tui.affiche("Ajout réussi !");
        } catch (Exception e) {
            tui.affiche(e.getMessage());
        }
    }
}
