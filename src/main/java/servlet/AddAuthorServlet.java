package servlet;

import model.Author;
import storage.InMemoryAuthorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addAuthor", name="AddAuthorServlet")

public class AddAuthorServlet extends HttpServlet {
    InMemoryAuthorStorage inMemoryAuthorStorage=new InMemoryAuthorStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/addAuthor.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authorName = req.getParameter("name");

        if (inMemoryAuthorStorage.checkAuthor(authorName)) {
            req.setAttribute("massage","Автор именем "+authorName+" уже существует");
        }else {
            inMemoryAuthorStorage.save(new Author(authorName));
            req.setAttribute("massage","Автор "+authorName+" создан");
        }
        req.getServletContext().getRequestDispatcher("/pages/addAuthor.jsp").forward(req, resp);
    }
}
