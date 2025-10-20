public class CommandeInvalide implements Commande {
    private String ligne;
    public CommandeInvalide(String ligne) { this.ligne = ligne; }
    public void execute(Dns dns, DnsTUI tui) {
        tui.affiche("Commande invalide : " + ligne);
    }
}
