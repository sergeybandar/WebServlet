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

@WebServlet(urlPatterns = "/role", name="RoleServlet")
public class RoleServlet extends HttpServlet {
InMemoryUserStorage inMemoryUserStorage=new InMemoryUserStorage();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User user = inMemoryUserStorage.getByLogin(login);
        if(user.getRole().equals(Role.USER)&&!user.getRole().equals(Role.SUPER_ADMIN)){
            user.setRole(Role.ADMIN);
        }else if (user.getRole().equals(Role.ADMIN)&&!user.getRole().equals(Role.SUPER_ADMIN)){
            user.setRole(Role.USER);
        }
        resp.sendRedirect("/allInfo");
    }
}
