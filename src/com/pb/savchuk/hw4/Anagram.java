package com.pb.savchuk.hw4;

import com.pb.savchuk.hw3.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static boolean isAnagram(String s1, String s2){

        if ( s1.length() != s2.length() ) {
            return false;
        }
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String sc1 = new String(c1);
        String sc2 = new String(c2);
        return sc1.equals(sc2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть перший рядок");
        String line1 = scanner.nextLine();
        System.out.println("Введіть другий рядок");
        String line2 = scanner.nextLine();
        String lettersOnly1 = line1.replaceAll("[\\W]", "");
        String lettersOnly2 = line2.replaceAll("[\\W]", "");
        System.out.println(isAnagram(lettersOnly1, lettersOnly2));

    }
}
