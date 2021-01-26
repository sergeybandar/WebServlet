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

@WebServlet(urlPatterns = "/auth", name="AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String result = "";
        boolean isAuthorised = false;
        User byLogin = inMemoryUserStorage.getByLogin(login);
        if (byLogin != null) {
            if (password.equals(byLogin.getPassword())) {
                req.getSession().setAttribute("user", byLogin);
                req.getSession().setAttribute("isGuest", false);
                req.getSession().setAttribute("isUser", true);
                if (byLogin.getRole().equals(Role.ADMIN)){
                    req.getSession().setAttribute("isAdmin", true);
                }
                if (byLogin.getRole().equals(Role.SUPER_ADMIN)){
                    req.getSession().setAttribute("isAdmin", true);
                    req.getSession().setAttribute("isSuperAdmin", true);
                }
                result = "Authorization complete";
                isAuthorised = true;

            } else {
                result = "incorrect password";
            }
        } else {
            result = "incorrect login";
        }
        if (isAuthorised) {
            resp.sendRedirect("/");
        } else {
            req.setAttribute("result", result);
            req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
    }
}
