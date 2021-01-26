package servlet;

import model.Author;
import storage.InMemoryAuthorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/authors", name="AuthorsServlet")
public class AuthorsServlet extends HttpServlet {
    InMemoryAuthorStorage inMemoryAuthorStorage=new InMemoryAuthorStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors=inMemoryAuthorStorage.getAllAuthors();
        req.setAttribute("authors", authors);
        getServletContext().getRequestDispatcher("/pages/authors.jsp").forward(req, resp);
    }
}