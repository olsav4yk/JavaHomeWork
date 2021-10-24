package com.pb.savchuk.hw3;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {

        /*Random random = new Random();
        int number = random.nextInt(101);
         */
        double r = Math.random() * 101;
        int number = (int) r;

        int count = 0;
        boolean target = true;
        int down = 0;
        int up = 100;

        while (target) {

            Scanner scaner = new Scanner(System.in);
            System.out.println("Введіть ціле число від " + down + " до " + up);
            int input = scaner.nextInt();
            count++;

            if (input == number) {
                System.out.println("Бінго! Ви відгадали. Кількість спроб - " + count);
                target = false;
            } else if (input < number) {
                System.out.println("Введене число " + input + " менше загаданого");
                down = input;

                System.out.println("Якщо бажаєте закінчити введіть від'ємне ціле число, якщо бажаєте продовжити введіть додатнє ціле число");
                int input2 = scaner.nextInt();
                if (input2 < 0) {
                    target = false;
                }
            } else {
                System.out.println("Введене число " + input + " більше загаданого");
                up = input;

                System.out.println("Якщо бажаєте закінчити введіть від'ємне ціле число, якщо бажаєте продовжити введіть додатнє ціле число");
                int input2 = scaner.nextInt();
                if (input2 < 0) {
                    target = false;
                }
            }
        }
    }
}