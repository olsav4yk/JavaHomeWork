package com.pb.savchuk.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Integer> array = new NumBox<Integer>(4);
        try {
            array.add(5);
            array.add(4);
            array.add(3);
           // array.add(2);


            System.out.println("Число из масива: " + array.get(0));
            System.out.println("Длина массива: " + array.length());
            System.out.println("Среднее арифметическое массива: " + array.average());
            System.out.println("Сумма всех элементов массива: " + array.sum());
            System.out.println("Максимальный элемент массива: " + array.max());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка! Вы перегрузили массив. Удалите лишние элементы");
        }
        System.out.println();
        NumBox<Float> array1 = new NumBox<Float>(4);
        try {
            array1.add(2.1f);
            array1.add(4.2f);
            array1.add(3.3f);
            array1.add(2.4f);


            System.out.println("Число из масива: " + array1.get(1));
            System.out.println("Длина массива: " + array1.length());
            System.out.println("Среднее арифметическое массива: " + array1.average());
            System.out.println("Сумма всех элементов массива: " + array1.sum());
            System.out.println("Максимальный элемент массива: " + array1.max());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка! Вы перегрузили массив. Удалите лишние элементы");
        }
    }
}
