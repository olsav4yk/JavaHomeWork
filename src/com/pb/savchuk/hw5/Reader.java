package com.pb.savchuk.hw5;
import java.util.Arrays;

public class Reader {

    String name;
    String id;
    String faculty;
    String birthDate;
    String phoneNumber;

    public Reader(String name, String id, String faculty, String birthDate, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    String getInfo() {
        return "ФИО: " + name + ", номер читательского билета: " + id +
                ", факультет: " + faculty + ", дата рождения: " + birthDate + ", телефон: " + phoneNumber + "";
    }
    public void takeBook(int count) {
        System.out.println("\n" + name + " взял " + count + " книги.");
    }
    public void takeBook(String... names) {
        System.out.println("\n" + name + " взял книги: " + Arrays.toString(names).replaceAll("\\[|\\]", "") + ".");
    }
    public void takeBook(Book... books) {
        System.out.print("\n" + name + " взял книги: \n");
        for (Book book : books) {
            System.out.println(book.getTitle() + " (" + book.getAuthor() + " " + book.getYear() + ")");

        }

    }
    public void returnBook(int count) {
        System.out.println("\n" + name + " вернул " + count + " книги ");
    }
    public void returnBook(String... titles) {
        System.out.println("\n" + name + " вернул книги: " + Arrays.toString(titles).replaceAll("\\[|\\]", ""));
    }
    public void returnBook(Book... books) {
        System.out.print("\n" + name + " вернул книги: \n");
        for (Book book : books) {
            System.out.println(book.getTitle() + " (" + book.getAuthor() + " " + book.getYear() + ")");

        }

    }
}