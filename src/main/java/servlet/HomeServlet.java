package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        model.User user = (model.User) req.getSession().getAttribute("user");
        String result = "guest";
        if (user != null) {
            result = user.getName();
        }
        req.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);
    }

}