package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/* 
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        NumberSystem sourceNumberSystem = number.getNumberSystem();
        String digit = number.getDigit();

        BigInteger value;
        try {
            value = new BigInteger(digit, sourceNumberSystem.getNumberSystemIntValue());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The digit " + digit +
                    " is not valid for the number system " + sourceNumberSystem.getNumberSystemIntValue());
        }

        String resultDigit = value.toString(expectedNumberSystem.getNumberSystemIntValue());

        return new Number(expectedNumberSystem, resultDigit);
    }
}
