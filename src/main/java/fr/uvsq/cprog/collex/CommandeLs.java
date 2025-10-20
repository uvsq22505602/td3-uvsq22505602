import java.util.*;
public class CommandeLs implements Commande {
    private String ligne;
    public CommandeLs(String ligne) { this.ligne = ligne.trim(); }
    public void execute(Dns dns, DnsTUI tui) {
        boolean parAdresse = ligne.contains("-a");
        String[] parties = ligne.split(" ");
        String domaine = parties[parties.length - 1];
        List<DnsItem> liste = dns.getItems(domaine);
        if (parAdresse) liste.sort(Comparator.comparing(o -> o.getAdresseIP().toString()));
        else liste.sort(Comparator.comparing(o -> o.getNomMachine().toString()));
        for (DnsItem item : liste) tui.affiche(item.toString());
    }
}
