package servlet;

import model.Basket;
import model.Book;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/books/book", name = "BookServlet")
public class BookServlet extends HttpServlet {
    private InMemoryBookStorage inMemoryBookStorage = new InMemoryBookStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book=inMemoryBookStorage.getById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("book", book);
        req.getServletContext().getRequestDispatcher("/pages/book.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book byId = inMemoryBookStorage.getById(Integer.parseInt(id));
        Basket basket = (Basket) req.getSession().getAttribute("basket");
        basket.addBook(byId);
        if(req.getParameter("redirect")==null){
            resp.sendRedirect("/books/book?id=" + id);
        }else {
            resp.sendRedirect("/"+req.getParameter("redirect"));
        }

    }
}
