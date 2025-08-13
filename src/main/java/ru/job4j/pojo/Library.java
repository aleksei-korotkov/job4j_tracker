package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 400);
        Book book2 = new Book("Java. Полное руководство", 600);
        Book book3 = new Book("Java в примерах. Справочник", 500);
        Book book4 = new Book("Java. Карманный справочник", 200);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberPages() + " стр.");
        }
        books[0] = book4;
        books[3] = book1;
        System.out.println("Replace book1 and book4.");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberPages() + " стр.");
        }
        System.out.println("Shown only Clean code:");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getNumberPages() + " стр.");
            }
        }
    }
}