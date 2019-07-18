package servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servletContext1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context  = this.getServletContext();
        String parameter = context.getInitParameter("url");
        String realPath_b = context.getRealPath("WEB_INF/classes/b.txt");
        String realPath_a = context.getRealPath("WEB_INF/a.txt");
        System.out.println("para=" + parameter +" + path_a=" + realPath_a + " + path_b=" + realPath_b);
        context.setAttribute("zz","qqq");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
