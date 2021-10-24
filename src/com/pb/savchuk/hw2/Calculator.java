package com.pb.savchuk.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1, operand2;
        String sign;

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первое число");
        operand1 = scan.nextInt();
        System.out.println("Введите второе число");
        operand2 = scan.nextInt();
        System.out.println("Введите знак операции из представленых: +, -, *, /");
        sign = scan.next();

        switch (sign){
            case "+":
                System.out.println(operand1 + " + "+ operand2 + " = " + operand1 + operand2);
                break;
        }
        switch (sign){
            case "-":
                System.out.println(operand1 + " - "+ operand2 + " = " + (operand1 - operand2));
                break;
        }
        switch (sign){
            case "*":
                System.out.println(operand1 + " * "+ operand2 + " = " + operand1 * operand2);
                break;
        }
        switch (sign){
            case "/":
                if (operand2==0){
                    System.out.println("Деление на 0 невозможно!");
                    break;
                }

                System.out.println(operand1 + " / "+ operand2 + " = " + operand1 / operand2);
                break;
        }

    }
}
