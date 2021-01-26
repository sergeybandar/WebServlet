package servlet;

import model.Book;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books", name = "BooksServlet")
public class BooksServlet extends HttpServlet {
    private InMemoryBookStorage inMemoryBookStorage = new InMemoryBookStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = inMemoryBookStorage.getAllBook();
        req.setAttribute("books", books);
        req.getServletContext().getRequestDispatcher("/pages/books.jsp").forward(req, resp);
    }
}
