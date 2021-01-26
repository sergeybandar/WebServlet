package servlet;

import model.Book;
import storage.InMemoryAuthorStorage;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addBook", name="AddBookServlet")
public class AddBookServlet extends HttpServlet {
    InMemoryAuthorStorage inMemoryAuthorStorage=new InMemoryAuthorStorage();
    InMemoryBookStorage inMemoryBookStorage=new InMemoryBookStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/addBook.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String poster = req.getParameter("poster");
        String authorName = req.getParameter("author");
        System.out.println(authorName);
        if (inMemoryAuthorStorage.checkAuthor(authorName)) {
            Book book=new Book(name, poster,authorName);
            inMemoryBookStorage.save(book);
            req.setAttribute("massage","Книга добавлена");
            req.setAttribute("book", book);
        }else {
            req.setAttribute("massage","Такого автора не существует. Добавьте автора.");
        }
        req.getServletContext().getRequestDispatcher("/pages/addBook.jsp").forward(req, resp);
    }

}
