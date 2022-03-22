package converter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConverterService {
    private int number;
    private Map<Integer, Character> map =
            Map.of(10,'a',
                    11,'b',
                    12,'c',
                    13,'d',
                    14,'e',
                    15,'f');

    public ConverterService(int number) {
        this.number = number;
    }

    public ConverterService() {

    }

    public String toBinary(int number) {
        String result = "";
        while (number > 0) {
            result = (number % 2) + result;
            number /= 2;
        }

        return result;
    }

    public int fromBinarytoDecimal(String text) {
        int result = 0;
        int a = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '1') {
                for (int j = 1; j < text.length() - i; j++) {
                    a *= 2;
                }
                result += a;
                a = 1;
            }
        }
        return result;
    }


    public String toOctal(int number) {
        String result = "";

        while (number > 0) {
            result = (number % 8) + result;
            number /= 8;
        }

        return result;
    }

    public String toHexa(int number) {
        String result = "";
        while (number > 0) {
            if (map.get(number % 16) != null) {
                result = map.get(number % 16) + result;
            } else {
                result = (number % 16) + result;
            }
            number /= 16;
        }

        return result;
    }

    public int fromOctaltoDecimal(String text) {
        int result = 0;
        int a = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '0') {
                if (i == text.length() - 1) {
                    result += Integer.parseInt(String.valueOf(text.charAt(i))) * a;
                } else {
                    for (int j = 1; j < text.length() - i; j++) {
                        a *= 8;
                    }
                    result += Integer.parseInt(String.valueOf(text.charAt(i))) * a;
                    a = 1;
                }
            } else {
                if (i == text.length() - 1) {
                    result += 1;
                }
            }
        }
        return result;
    }

    public int fromHexatoDecimal(String text) {

        int result = 0;
        int a = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '0') {
                if (i == text.length() - 1) {
                    result += Integer.parseInt(String.valueOf(text.charAt(i))) * a;
                } else {
                    for (int j = 1; j < text.length() - i; j++) {
                        a *= 16;
                    }
                    result += Integer.parseInt(String.valueOf(text.charAt(i))) * a;
                    a = 1;
                }
            } else {
                if (i == text.length() - 1) {
                    result += 1;
                }
            }
        }
        return result;
    }
}
