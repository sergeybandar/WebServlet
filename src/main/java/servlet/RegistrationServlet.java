package servlet;

import model.Role;
import model.User;
import storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg", name="RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String result = "";
        boolean isRegistered = false;
        if (name != null && login != null && password != null) {
            if (name.length() >= 2 && login.length() >= 2 && password.length() >= 2) {
                if (inMemoryUserStorage.reg(login)) {
                    User user = new User(name, login, password, Role.USER);
                    result = "Registration complete";
                    inMemoryUserStorage.save(user);
                    isRegistered = true;
                } else {
                    result = "login exists";
                }
            } else {
                result = "Incorrect data, your name or login or password do not contain two symbols";
            }
        } else {
            result = "You aren't write name or login or password";
        }


        if (isRegistered) {
            resp.sendRedirect("/auth");
        } else {
            req.setAttribute("result", result);
            req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
        }
    }
}
