import java.util.StringJoiner;

public class Subnetz {
    private StringJoiner binäreAdresse = new StringJoiner(".");
    private StringJoiner binäreSubAdresse = new StringJoiner(".");
    private StringJoiner dezimaleNetzwerkId = new StringJoiner(".");
    private StringJoiner dezimaleBroadcastIp = new StringJoiner(".");

    private String binäreNetzwerkId = new String();
    private String binäreBroadcastAdresse = new String();
    private long hostAnzahl;
    public Subnetz(String decIp, String decSubNet) {
        this.wandleIpv4InBin(decIp);
        this.wandleSubInBin(decSubNet);
        this.netzId();
        this.broadcastAdresse();
        this.hostAnzahl = this.anzahlHostadressen();
        this.wandleAdressenInDezimal();

    }

    public StringJoiner getDezimaleNetzwerkId() {
        return dezimaleNetzwerkId;
    }

    public StringJoiner getDezimaleBroadcastIp() {
        return dezimaleBroadcastIp;
    }

    public long getHostAnzahl() {
        return hostAnzahl;
    }

    private void wandleIpv4InBin(String givenIpv4Address) {
        String[] octets = givenIpv4Address.split("\\.");
        for (String octet : octets) {
            int dezimalwert = Integer.parseInt(octet);
            String binärwert = Integer.toBinaryString(dezimalwert);
            int missingBits = 8 - binärwert.length();
            for (int i = 0; i < missingBits; i++) {
                binärwert += "0";
            }
            binäreAdresse.add(binärwert);
        }
    }

    private void wandleSubInBin(String givenSubnetz) {
        String[] octets = givenSubnetz.split("\\.");
        for (String octet : octets) {
            int dezimalwertSub = Integer.parseInt(octet);
            String binärwertSub = Integer.toBinaryString(dezimalwertSub);
            int missingBits = 8 - binärwertSub.length();
            for (int i = 0; i < missingBits; i++) {
                binärwertSub = "0" + binärwertSub;
            }
            binäreSubAdresse.add(binärwertSub);
        }
    }

    private void netzId() {
        for (int i = 0; i <= binäreAdresse.length() - 1; i++) {
            if (binäreAdresse.toString().charAt(i) == '1' && binäreSubAdresse.toString().charAt(i) == '1') {
                binäreNetzwerkId += "1";
            }
            if (binäreAdresse.toString().charAt(i) == '.') {
                binäreNetzwerkId += ".";
            }
            if (binäreAdresse.toString().charAt(i) == '0' || binäreSubAdresse.toString().charAt(i) == '0') {
                binäreNetzwerkId += "0";
            }
        }
    }

    private void broadcastAdresse() {
        int freieStellen = 0;
        for (int j = binäreSubAdresse.length() - 1; j >= 0; j--) {
            char aktuellesBit = binäreSubAdresse.toString().charAt(j);
            if (aktuellesBit == '1') {
                break;
            } else if (aktuellesBit == '0' || aktuellesBit == '.') {
                freieStellen++;
            }
        }
        String substring1 = binäreAdresse.toString().substring(0, 35 - freieStellen);
        String substring2 = binäreAdresse.toString().substring(35 - freieStellen);
        substring2 = substring2.replaceAll("0", "1");
        binäreBroadcastAdresse = substring1 + substring2;
    }

    public long anzahlHostadressen() {
        int freiStellen = 0;

        for (int j = binäreSubAdresse.length() - 1; j >= 0; j--) {
            char aktuellesBit = binäreSubAdresse.toString().charAt(j);
            if (aktuellesBit == '1') {
                break;
            } else if (aktuellesBit == '0') {
                freiStellen++;
            }
        }
        long anzahlHostadressen = (long) (Math.pow(2, freiStellen) - 2);
        return anzahlHostadressen;
    }

    public void wandleAdressenInDezimal() {
        String[] octets = binäreNetzwerkId.split("\\.");
        for (String octet : octets) {
            int dezimalwert = Integer.parseInt(octet, 2);
            dezimaleNetzwerkId.add(dezimalwert + "");
        }
        String[] octetS = binäreBroadcastAdresse.split("\\.");
        for (String octet : octetS) {
            int dezimalwert = Integer.parseInt(octet, 2);
            dezimaleBroadcastIp.add(dezimalwert + "");
        }
    }
}
