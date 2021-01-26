package model;
import java.util.ArrayList;
import java.util.List;


public class Author {
    static int authorId=0;
    private String name;
    private int id;
    private List<Book> books=new ArrayList<>();

    public Author(String name) {
        this.name = name;
        id=authorId;
        authorId++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void bookAdd(Book book){
        books.add(book);
    }
    public List<Book> getAllBook(){
        return new ArrayList<>(books);
    }
}
