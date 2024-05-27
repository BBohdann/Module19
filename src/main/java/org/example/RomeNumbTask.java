package org.example;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class RomeNumbTask {
    public static void main(String[] args) {
        System.out.println("Введіть 2 римських числа:");
        Scanner scanner = new Scanner(System.in);
        System.out.println(new RomeNumbTask().calculate(scanner.nextLine()));
    }
    public int romeToArabicI(String rome) {
        int result =0;
        char[] symbol = rome.toCharArray();
        Map<Character,Integer> romeAndArabicValues = new HashMap<>();
        romeAndArabicValues.put('I', 1);
        romeAndArabicValues.put('V', 5);
        romeAndArabicValues.put('X', 10);
        romeAndArabicValues.put('L', 50);
        romeAndArabicValues.put('C', 100);
        romeAndArabicValues.put('D', 500);
        romeAndArabicValues.put('M', 1000);

        for (int i=0;i<symbol.length;i++){
            char currentSymbol = symbol[i];
            int currentArabicValue = romeAndArabicValues.get(currentSymbol);
            if (i == symbol.length-1){
                result +=currentArabicValue;
            }else {
                char nextSymbol = symbol[i+1];
                int nextArabicValues = romeAndArabicValues.get(nextSymbol);
                if (nextArabicValues>currentArabicValue){
                    result += nextArabicValues - currentArabicValue;
                }else {
                    result += nextArabicValues + currentArabicValue;
                }
                i++;
            }
        }
        return result;
    }

    public static String arabicToRome(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public String calculate(String expression) {
        int result = Arrays.stream(expression.split("\\+")).mapToInt(it -> romeToArabicI(it)).sum();
        return arabicToRome(result);
    }

    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }
}
