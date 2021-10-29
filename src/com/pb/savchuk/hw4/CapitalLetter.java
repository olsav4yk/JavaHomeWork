package com.pb.savchuk.hw4;


import java.util.Scanner;

public class CapitalLetter {

    public static String upFirstLetter(String givenString) {
        String[] arr = givenString.split(" " );
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
           sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        Scanner scaner=new Scanner(System.in);
        System.out.println("Введіть Ваш текст:");
        String givenString = scaner.nextLine();

        System.out.println(upFirstLetter(givenString));
    }
}
