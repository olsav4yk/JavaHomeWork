package com.pb.savchuk.hw5;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Приключения","Иванов И. И.", "2000 г." );
        Book book2 = new Book("Словарь","Сидоров А. В.", "1980 г." );
        Book book3 = new Book("Энциклопедия","Гусев К. В.", "2010 г." );

        Reader reader1 = new Reader("Петров В. В.","1", "11", "01.01.2000", "0930000000");
        Reader reader2 = new Reader("Иванчук И.И.","2", "22", "02.02.2002", "0630000000");
        Reader reader3 = new Reader("Сидорчук С.С.","3", "33", "03.03.2003", "0670000000");

        System.out.println("Список книг:" + book1.bookInfo() + ", " + book2.bookInfo() + ", " + book3.bookInfo());
        System.out.println("\nСписок читателей:\n" + reader1.getInfo() + ", \n" + reader2.getInfo() + ", \n" + reader3.getInfo() + ".");

        reader1.takeBook(3);
        reader1.takeBook(book1.title, book2.title, book3.title);
        reader1.takeBook(book1, book2, book3);

        reader1.returnBook(3);
        reader1.returnBook(book1.title, book2.title, book3.title);
        reader1.returnBook(book1, book2, book3);
    }
}