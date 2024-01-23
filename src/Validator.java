import org.apache.commons.validator.routines.InetAddressValidator;
public class Validator {
    private static final InetAddressValidator validator = InetAddressValidator.getInstance();
    public static boolean isValidIpAddress(String givenIpv4Address) {
        return validator.isValidInet4Address(givenIpv4Address);
    }

    public static boolean isValidSubnetMask(String givenSubnetz) {
        if (givenSubnetz.equals("128.0.0.0") || givenSubnetz.equals("192.0.0.0") || givenSubnetz.equals("224.0.0.0") ||
                givenSubnetz.equals("240.0.0.0") ||givenSubnetz.equals("248.0.0.0") ||
                givenSubnetz.equals("252.0.0.0") ||givenSubnetz.equals("254.0.0.0")||
                givenSubnetz.equals("255.0.0.0") || givenSubnetz.equals("255.128.0.0") ||
                givenSubnetz.equals("255.192.0.0") || givenSubnetz.equals("255.224.0.0") ||
                givenSubnetz.equals("255.240.0.0") || givenSubnetz.equals("255.248.0.0") ||
                givenSubnetz.equals("255.252.0.0") || givenSubnetz.equals("255.254.0.0") ||
                givenSubnetz.equals("255.255.0.0") || givenSubnetz.equals("255.255.128.0") ||
                givenSubnetz.equals("255.255.192.0") || givenSubnetz.equals("255.255.224.0") ||
                givenSubnetz.equals("255.255.240.0") || givenSubnetz.equals("255.255.248.0") ||
                givenSubnetz.equals("255.255.252.0") || givenSubnetz.equals("255.255.254.0") ||
                givenSubnetz.equals("255.255.255.0") || givenSubnetz.equals("255.255.255.128") ||
                givenSubnetz.equals("255.255.255.192") || givenSubnetz.equals("255.255.255.224") ||
                givenSubnetz.equals("255.255.255.240") || givenSubnetz.equals("255.255.255.248") ||
                givenSubnetz.equals("255.255.255.252") || givenSubnetz.equals("255.255.255.254") ||
                givenSubnetz.equals("255.255.255.255")) {
            return true;
        }
        return false;
    }
}
