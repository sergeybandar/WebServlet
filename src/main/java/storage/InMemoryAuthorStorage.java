package storage;

import model.Author;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthorStorage {
    private static List<Author> authors = new ArrayList<>();
    static {
        authors.add(new Author("Alla YaLissa"));
        authors.add(new Author("Ганц Ока"));
        authors.add(new Author("Полина Мельник"));
        authors.add(new Author("Wicked Petrel"));

    }
    public void save(Author author) {
        authors.add(author);
    }

    public Author getByName(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return author;
            }
        }
        return null;
    }
    public boolean checkAuthor(String name) {
        for(Author author: authors) {
            if (name.equals(author.getName())) {
                return true;
            }
        }
        return false;
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }
    public Author getById(int id) {
        for (Author author : authors) {
            if (author.getId() == id) return author;
        }
        return null;
    }
}
