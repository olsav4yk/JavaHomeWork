package com.pb.savchuk.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        int sum = 0;
        int neg = 0;
        int poz = 0;

        Scanner scaner=new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Введіть " + (i + 1) + " елемент масиву:");
            array[i] = scaner.nextInt();
        }
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {


            System.out.print(array[i]+" ");
            sum = sum + array[i];

            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
            if (array[i] < 0);
            neg++;
            if (array[i] > 0);
            poz++;
        }

        System.out.println("\nСума всіх елементів масиву = " + sum);
        System.out.println("Мінімальне значення масиву = " + min);
        System.out.println("Максимальне значення масиву = " + max);
        System.out.println("Кількість негативних елементів = " + neg);
        System.out.println("Кількість позитивних елементів = " + poz);
    }
}
