package servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class sessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("name","lisi");
        String id = session.getId();
        Cookie cookie = new Cookie("JSESSIONID" , id);
        cookie.setMaxAge(60*10);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
