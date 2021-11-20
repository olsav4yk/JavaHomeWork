package com.pb.savchuk.hw8;


import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth user = new Auth();


        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Для регистрации пользователя ведите логин");
            String signUpLogin = scanner.nextLine();
            System.out.println("Введите пароль");
            String signUpPassword = scanner.nextLine();
            System.out.println("Введите повторный пароль");
            String signUpConfirmPassword = scanner.nextLine();
            user.signUp(signUpLogin, signUpPassword, signUpConfirmPassword);
            System.out.println("Ваш аккаунт создан!");
            System.out.println();
            System.out.println("Для входа введите Ваш логин");
            String signInLogin = scanner.nextLine();
            System.out.println("Введите Ваш пароль");
            String signInPassword = scanner.nextLine();
            user.signIn(signInLogin, signInPassword);


        } catch (WrongPasswordException e) {
            if (user.getLogin() != null && user.getPassword() != null) {
                System.out.println("Извините, но Ваш логин или пароль не верный");
            } else {
                System.out.println("Извините, но Ваш логин или пароль не соответствует требованиям");

            }
        } catch (WrongLoginException e){
            e.printStackTrace();
        }
    }
}
