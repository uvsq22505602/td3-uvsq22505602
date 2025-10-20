public class CommandeQuit implements Commande {
    public void execute(Dns dns, DnsTUI tui) {
        tui.affiche("Fermeture du programme...");
        System.exit(0);
    }
}
