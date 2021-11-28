package com.pb.savchuk.hw10;

public class NumBox <T extends Number>{
    private T[] arr;
    int input = 0;
    public NumBox(int size) {
        arr = (T[]) new Number[size];
    }

    public void add(T num) throws ArrayIndexOutOfBoundsException{

        this.arr[input] = num;
        ++input;

        if (input > arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        return arr[index];
    }

    public int length(){
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                length = i;
                break;
            } else {
                length = arr.length;
            }
        }
    return length;
    }

    public double average(){
        double aver = 0;
        int a = 0;
        for (int i = 0; i<arr.length; i++){
            if (arr[i] != null) {
                aver += arr[i].doubleValue();
                a++;
            }
        }
        aver /= a;
    return aver;
    }

    public double sum(){
        double amount = 0;
        for (int i = 0; i<arr.length; i++){
            if (arr[i] != null) {
                amount += arr[i].doubleValue();
            }
        }
    return amount;
    }

    public T max(){
        T maxValue = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (arr[i] != null) {
                if (arr[i].doubleValue() > maxValue.doubleValue()) {
                    maxValue = arr[i];
                }
            }
        }
        return maxValue;
    }
}
