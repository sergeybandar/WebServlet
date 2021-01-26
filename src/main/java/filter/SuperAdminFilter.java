package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"RoleServlet"})
public class SuperAdminFilter extends HttpFilter {
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if ((boolean)req.getSession().getAttribute("isSuperAdmin") ) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/");
        }
    }
}
