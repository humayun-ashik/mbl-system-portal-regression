package com.konasl.mbl.utils;

public class RegexMethods {
    public static String returnDigitFromString(String inputText){
        return inputText.replaceAll("\\D+","");
    }
}
