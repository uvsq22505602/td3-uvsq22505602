public class DnsApp {
    public static void main(String[] args) {
        Dns dns = new Dns("dns.txt");
        DnsTUI tui = new DnsTUI();
        while (true) {
            Commande cmd = tui.nextCommande();
            cmd.execute(dns, tui);
        }
    }
}
