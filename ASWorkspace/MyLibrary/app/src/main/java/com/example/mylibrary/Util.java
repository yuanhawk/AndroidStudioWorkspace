package com.example.mylibrary;

import java.util.ArrayList;

public class Util {

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;

    private static int id = 0;

    public Util() {
        if(allBooks == null) {
            allBooks = new ArrayList<>();
            initAllBooks();
        }
        if(currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if(wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<>();
        }
        if(alreadyReadBooks == null) {
            alreadyReadBooks = new ArrayList<>();
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurrentlyReadingBook (Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean addWantToReadBooks (Book book) {
        return wantToReadBooks.add(book);
    }

    public boolean addAlreadyReadBooks (Book book) {
        return alreadyReadBooks.add(book);
    }

    public boolean removeCurrentlyReadingBooks (Book book) {
        return currentlyReadingBooks.remove(book);
    }

    public boolean removeWantToReadBooks (Book book) {
        return wantToReadBooks.remove(book);
    }

    public boolean removeAlreadyReadBooks(Book book) {
        return alreadyReadBooks.remove(book);
    }

    private static void initAllBooks() {

        String name = "";
        String author = "";
        int pages = 0;
        String imageUrl = "";
        String description = "";

        id++;
        name = "Still Me";
        author = "Jojo Moyes";
        pages = 390;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1502818159l/35791968.jpg";
        description = "Jojo Moyes wins the Best Fiction award for her third book in the Me Before You series (the first book was adapted into a tearjerker of a movie). Here heroine Louisa Clark ventures to New York City to start a new life. This is the British author’s first Goodreads Choice Award.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "The Outsider";
        author = "Stephen King";
        pages = 561;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1524596540l/36124936._SY475_.jpg";
        description = "Stephen King is no stranger to the Goodreads Choice Awards. And although fans may know him best as a horror novelist, this is his third win in the Goodreads Choice Awards Mystery & Thriller category (he also earned wins here for End of Watch in 2016 and Mr. Mercedes in 2014). This year he beat out the debut The Woman in the Window to take the title.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));
    }
}
