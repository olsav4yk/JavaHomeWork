package com.pb.savchuk.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        int sum = 0;
        int poz = 0;

        Scanner scaner=new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Введіть " + (i + 1) + " елемент масиву:");
            array[i] = scaner.nextInt();
        }
        int neg = 0;
        int min = array[0];
        int max = array[0];
        System.out.println("Ведений масив має вигляд: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
            sum += array[i];

            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < 0) {
                neg++;
            }
            if (array[i] > 0) {
                poz++;
            }
        }

        for (int out = array.length - 1; out >= 1; out--) {
            for (int i = 0; i < out; i++) {
                if (array[i] > array[i + 1]) {
                    int swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;

                }
            }
        }
        System.out.println("\nВідсортований масив має вигляд: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nСума всіх елементів масиву = " + sum);
        System.out.println("Мінімальне значення масиву = " + min);
        System.out.println("Максимальне значення масиву = " + max);
        System.out.println("Кількість негативних елементів = " + neg);
        System.out.println("Кількість позитивних елементів = " + poz);
    }
}
