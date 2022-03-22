package converter;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ConverterService converterService = new ConverterService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit)");
            String type = scanner.next();
            if ("/from".equals(type)) {
                System.out.print("Enter a number in decimal system: ");
                int Number = scanner.nextInt();
                System.out.print("Enter the target base: ");
                int base = scanner.nextInt();
                fromDecimal(base, Number);
            } else if ("/to".equals(type)) {
                System.out.print("Enter source number: ");
                String Number = scanner.next();
                System.out.print("Enter source base: ");
                int base = scanner.nextInt();
                toDecimal(Number, base);
            } else if ("/exit".equals(type)) {
                break;
            }
        }


    }


    public static void toDecimal(String number, int targetNumber) {
        ConverterService converterService = new ConverterService();
        switch (targetNumber) {
            case 2:
                System.out.println("Conversion to decimal result: " + converterService.fromBinarytoDecimal(number));
                break;
            case 8:
                System.out.println("Conversion to decimal result: " + converterService.fromOctaltoDecimal(number));
                break;
            case 16:
                System.out.println("Conversion to decimal result: " + converterService.fromHexatoDecimal(number));
                break;
            default:
                break;
        }
    }

    public static void fromDecimal(int targetNumber, int decimalNumber) {
        ConverterService converterService  = new ConverterService();
        switch (targetNumber) {
            case 2:
                System.out.println("Conversion result: " + converterService.toBinary(decimalNumber));
                break;
            case 8:
                System.out.println("Conversion result: " + converterService.toOctal(decimalNumber));
                break;
            case 16:
                System.out.println("Conversion result: " + converterService.toHexa(decimalNumber));
                break;
            default:
                break;

        }
    }
}
