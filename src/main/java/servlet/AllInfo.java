package servlet;

import model.User;
import storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allInfo", name="AllInfo")
public class AllInfo extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = inMemoryUserStorage.getAllUser();
        req.setAttribute("users", users);
        req.getServletContext().getRequestDispatcher("/pages/AllInfo.jsp").forward(req, resp);

    }
}