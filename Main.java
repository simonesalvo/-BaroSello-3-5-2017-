/**
 * Simone Salvo
 * simone.salvo@ymail.com
 */

public class Main {

    private static final String BARO = "Baro";
    private static final String SELLO = "Sello";
    private static final String BAROSELLO = "BaroSello";
    private static final String NARDO = "Nardo";

    private static final String GREEN = "GREEN";
    private static final String RED = "RED";
    private static final String BLUE = "BLUE";
    private static final String PURPLE = "PURPLE";


    public static void main(String[] args) {

        Boolean onlyBarosello = false;
        Boolean colorfull = false;
        Boolean useThirdPartyOutput = false;
        Boolean unlock7Feature = false;

        int numericValue = -1 ;

        try {
            if (args.length > 0) {
                numericValue = Integer.parseInt(args[0]);
                if (args.length > 1)
                    onlyBarosello = Boolean.parseBoolean(args[1]);
                if (args.length > 2)
                    colorfull = Boolean.parseBoolean(args[2]);
                if (args.length > 3)
                    useThirdPartyOutput = Boolean.parseBoolean(args[3]);
                if (args.length > 4)
                    unlock7Feature = Boolean.parseBoolean(args[4]);
            }

            if (numericValue >= 0) {
                if (numericValue % 3 == 0 && !onlyBarosello) {
                    if (useThirdPartyOutput)
                        UserThirdPartyOutput(BARO, colorfull, GREEN);
                    else
                        OwnPrintFunction(BARO, colorfull, GREEN);
                } else if (numericValue % 5 == 0 && !onlyBarosello) {
                    OwnPrintFunction(SELLO, colorfull, RED);
                } else if (unlock7Feature && numericValue % 7 == 0 && !onlyBarosello) {
                    OwnPrintFunction(NARDO, colorfull, PURPLE);
                } else if (numericValue % 3 == 0 && numericValue % 5 == 0 && onlyBarosello) {
                    if (useThirdPartyOutput)
                        UserThirdPartyOutput(BAROSELLO, colorfull, BLUE);
                    else
                        OwnPrintFunction(BAROSELLO, colorfull, BLUE);
                } else if (!onlyBarosello)
                    System.out.print(numericValue + " ");

            } else {
                System.out.println("Invalid numeric input ");
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid  input " + e.getMessage() + e.getStackTrace().toString());
        }
    }

    private static void OwnPrintFunction(String str, Boolean isColorFull, String color) {
        if (!isColorFull)
            System.out.print(str);
        else
        {
            //TODO use third party library to print colorful in console

            // As POC will print in the same output
            System.out.print(str);
        }

    }

    private static void UserThirdPartyOutput(String str, Boolean isColorFull, String color) {
        // TODO use third party APIs to print our string somewhere else i.e twitter APIs

        // As POC will print in the same output
        OwnPrintFunction(str, isColorFull, color);
    }
}
