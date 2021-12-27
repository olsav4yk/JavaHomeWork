package com.pb.savchuk.hw13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Program {

    public static void main(String[] args) {

        LinkedList <Integer> list = new LinkedList<>();
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(list, buffer);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
// Буфер, хранящий произведенные товары
class Buffer{

    List<Integer> integers = new ArrayList<>();


    public synchronized void get(LinkedList <Integer> list) {
        while (integers.size()<1) {
            try {
                wait(5000);
            }
            catch (InterruptedException e) {
            }
        }
        list.addAll(integers);
        integers.clear();
        System.out.println("Потребитель вигрузил элементы: " + list);
        System.out.println("Элементы в буфере: " + integers);
        notify();
    }
    public synchronized void put() {
        while (integers.size()>=5) {
            try {
                wait(5000);
            }
            catch (InterruptedException e) {
            }
        }
        int number = (1 + (int) (Math.random()*(5 - integers.size())));

        for (int i=0; i<number; i++){
            int number1 = (int) (Math.random()*100);
            integers.add(i, number1);
        }
        System.out.println("Производитель добавил элементы");
        System.out.println("Элементы в буфере: " + integers);
        notify();
    }
}
// Класс Производитель
class Producer implements Runnable{

    Buffer buffer;
    Producer(Buffer buffer){
        this.buffer=buffer;
    }
    public void run(){
        for (int i = 0; i < 5; i++) {
            buffer.put();
        }
    }
}
// Класс Потребитель
class Consumer implements Runnable{
    LinkedList <Integer> list1;
    Buffer buffer;

    public Consumer(LinkedList<Integer> list1, Buffer buffer) {
        this.list1 = list1;
        this.buffer = buffer;
    }

    public void run(){
        for (int i = 0; i < 5; i++) {
            buffer.get(list1);
        }
    }
}