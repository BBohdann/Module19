package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class RomeNumbTaskTest {
    @Test
    public void testThatRomeNumToArabicI(){
        Map<String,Integer> testCase = new HashMap<>();
        testCase.put("I",1);
        testCase.put("II",2);
        testCase.put("III",3);
        testCase.put("IV",4);
        testCase.put("V",5);
        testCase.put("VI",6);
        testCase.put("VII",7);
        testCase.put("VIII",8);
        testCase.put("IX",9);
        testCase.put("X",10);
        testCase.put("XV",15);
        testCase.put("XCVIII",98);
        testCase.put("ML",1050);
        testCase.put("MMM",3000);


        testCase.forEach((rome,expectedArabic)->
                Assertions.assertEquals(expectedArabic, new RomeNumbTask().romeToArabicI(rome),rome));
    }
    @Test
    public void testThatArabicToRomeMethothWorksOk(){
        Map<Integer,String> testCases = new HashMap<>();
        testCases.put(1,"I");
        testCases.put(2,"II");
        testCases.put(3,"III");
        testCases.put(4,"IV");
        testCases.put(5,"V");
        testCases.put(6,"VI");
        testCases.put(7,"VII");
        testCases.put(8,"VIII");
        testCases.put(9,"IX");
        testCases.put(10,"X");
        testCases.put(15,"XV");
        testCases.put(98,"XCVIII");
        testCases.put(1050,"ML");
        testCases.put(3000,"MMM");
        testCases.forEach((arabic,expectedRome)->
                Assertions.assertEquals(expectedRome,
                new RomeNumbTask().arabicToRome(arabic),
                Integer.toString(arabic)
        ));
    }
    @Test
    public void testThatCalculateMethodCorrect(){
        Map<String,String> testCases = new HashMap<>();
        testCases.put("III+IV", "VII");
        testCases.put("I+VII", "VIII");
        testCases.put("I+V", "VI");
        testCases.forEach((expression,expected)->
                Assertions.assertEquals(expected,
                        new RomeNumbTask().calculate(expression),
                        expression));
    }
}