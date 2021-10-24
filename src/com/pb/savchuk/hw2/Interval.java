package com.pb.savchuk.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int var;

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число");
        var = scan.nextInt();

        if (var>=0 && var<=14) {
            System.out.println("Введенное число " + var + " находится в промежутке от 0 до 14");
            }else if (var>=15 && var<=35) {
                System.out.println("Введенное число " + var + " находится в промежутке от 15 до 35");
            }
            else if (var>=36 && var<=50) {
                System.out.println("Введенное число " + var + " находится в промежутке от 36 до 50");
            }
            else if (var>=51 && var<=100) {
                System.out.println("Введенное число " + var + " находится в промежутке от 51 до 100");
            }
            else {
                System.out.println("Введенное число " + var + " находится вне заданых промежутков");
            }

    }
}
