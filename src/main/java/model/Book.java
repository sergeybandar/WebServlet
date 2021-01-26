package model;

import storage.InMemoryAuthorStorage;

public class Book {
    private static int bookId=0;
    private String name;
    private String poster;
    private Author author;
    private int id;
    private InMemoryAuthorStorage inMemoryAuthorStorage=new InMemoryAuthorStorage();
    public Book(String name, String poster, String author) {
        this.name = name;
        this.poster = poster;
        Author auth=inMemoryAuthorStorage.getByName(author);
        this.author = auth;
        id=bookId;
        bookId++;
        auth.bookAdd(this);
    }

    public String getName() {
        return name;
    }

    public String getPoster() {
        return poster;
    }

    public Author getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }
}
