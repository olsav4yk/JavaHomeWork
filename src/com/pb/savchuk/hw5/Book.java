package com.pb.savchuk.hw5;

public class Book {
    String title;
    String author;
    String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getYear() {
        return year;
    }

    String bookInfo() {
        return  "\nназвание: "+ title + ", автор: " + author + ", год издания: " + year;
    }
}

