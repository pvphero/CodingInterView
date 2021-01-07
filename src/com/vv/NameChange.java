package com.vv;


import java.util.Scanner;

/**
 * @author ShenZhenWei
 * @date 2020/11/27
 */
class NameChange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String s = toCamelCase(name);
        System.out.println(s);
    }

    static String toCamelCase(String s) {
        String[] parts = s.split("-");
        String camelCaseString = "";
        for (String part : parts) {
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return "track" + camelCaseString;
    }

    static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }
}
