import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Subnetz otherIp = new Subnetz(inputIp(scanner),inputSub(scanner));
        System.out.println("Die Anzahl der Hostadressen beträgt: " + otherIp.getHostAnzahl());
        System.out.println("Die Netzwerk ID in Dezimal ist: " + otherIp.getDezimaleNetzwerkId().toString());
        System.out.println("Die Broadcast IP in Dezimal ist: " + otherIp.getDezimaleBroadcastIp().toString());
    }
    private static String inputIp(Scanner eingabe) {

        while (true) {
            System.out.println("Bitte geben Sie die IP - Adresse ein");
            String givenIpv4Address = eingabe.nextLine();
            boolean isValidIp = Validator.isValidIpAddress(givenIpv4Address);
            if(!isValidIp) {
                System.out.println(givenIpv4Address + " ist keine gültige IP - Adresse. Bitte erneut eingeben");
                continue;
            }
            return givenIpv4Address;
        }
    }
    private static String inputSub(Scanner eingabe) {

        while (true) {
            System.out.println("Bitte geben Sie die Subnetzmaske ein");
            String givenSubnetz = eingabe.nextLine();
            boolean isValidIp = Validator.isValidSubnetMask(givenSubnetz);
            if(!isValidIp) {
                System.out.println(givenSubnetz + " ist keine gültige Subnetzmaske. Bitte erneut eingeben");
                continue;
            }
            return givenSubnetz;
        }
    }

}