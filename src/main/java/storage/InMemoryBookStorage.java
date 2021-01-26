package storage;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookStorage {
    private static List<Book> books = new ArrayList<>();

    static {
        InMemoryAuthorStorage inMemoryAuthorStorage = new InMemoryAuthorStorage();
        books.add(new Book("Жерло", "https://rust.litnet.com/uploads/covers/220/1575306565_18.jpg", "Ганц Ока"));
        books.add(new Book("Пуля. Рассказ", "https://rust.litnet.com/uploads/covers/220/1544030525_19.jpg", "Полина Мельник"));
        books.add(new Book("Тег Короля", "https://rust.litnet.com/uploads/covers/220/1544028420_94.jpg", "Полина Мельник"));
        books.add(new Book("Демоны Анны. Книга первая", "https://rust.litnet.com/uploads/covers/220/1544113506_27.jpg", "Полина Мельник"));
        books.add(new Book("Ликвидация", "https://rust.litnet.com/uploads/covers/220/1590736921_4.jpg", "Полина Мельник"));
        books.add(new Book("Хроники Дарона. Эльф под горой", "https://rust.litnet.com/uploads/covers/220/1579693346_100.jpg", "Полина Мельник"));
        books.add(new Book("Лесной хозяин", "https://rust.litnet.com/uploads/covers/220/1570364416_65.jpg", "Wicked Petrel"));
        books.add(new Book("Следуя за лесным огоньком", "https://rust.litnet.com/uploads/covers/220/1572888632_0.jpg", "Wicked Petrel"));

    }

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> getAllBook() {
        return new ArrayList<>(books);
    }

    public Book getById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }
}


