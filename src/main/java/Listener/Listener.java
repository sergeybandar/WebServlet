package Listener;

import model.Basket;
import storage.InMemoryAuthorStorage;
import storage.InMemoryBookStorage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener {//WebListener

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        InMemoryAuthorStorage inMemoryAuthorStorage = new InMemoryAuthorStorage();
        InMemoryBookStorage inMemoryBookStorage = new InMemoryBookStorage();
        se.getSession().setAttribute("basket", new Basket());
        se.getSession().setAttribute("isGuest", true);
        se.getSession().setAttribute("isUser", false);
        se.getSession().setAttribute("isAdmin", false);
        se.getSession().setAttribute("isSuperAdmin", false);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
